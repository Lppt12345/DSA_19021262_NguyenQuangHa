package Coursera.EightPuzzle;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class Solver {
    private boolean isSovl;
    private int moves;
    private final Stack<Board> solutionB = new Stack<>();

    private static class FindNode implements Comparable<FindNode> {
        private final Board board;
        private int step;
        private final int priority;
        private int manhattan;
        private final FindNode pre;

        public FindNode(Board board, FindNode pre) {
            this.board = board;
            this.pre = pre;
            if (pre == null) {
                step = 0;
            } else {
                step = pre.step + 1;
            }
            this.manhattan = board.manhattan();
            priority = step + manhattan;
        }

        @Override
        public int compareTo(FindNode o) {
            return Integer.compare(this.priority, o.priority);
        }
    }

    // find a solution to the initial board (using the A* algorithm)
    public Solver(Board initial) {
        if (initial == null) {
            throw new IllegalArgumentException("Dau vao bi null");
        }
        MinPQ<FindNode> findNodesPQ = new MinPQ<>();
        init(initial, findNodesPQ);
        while (true) {
            FindNode Node = findNodesPQ.min();
            if (Node.board.isGoal()){
                moves = Node.step;
                break;
            }
            FindNode getNode = findNodesPQ.delMin();
            Iterable<Board> neighbors = getNode.board.neighbors();
            for (Board board : neighbors) {
                if (getNode.pre == null) {
                    findNodesPQ.insert(new FindNode(board, getNode));
                }else {
                    if (!board.equals(getNode.pre.board)){
                        findNodesPQ.insert(new FindNode(board, getNode));
                    }
                }
            }
        }
        if (!findNodesPQ.isEmpty()) {
            addBoard(solutionB, findNodesPQ);
        }
        if (solutionB.peek().equals(initial)) {
//            System.out.println("DAY LA: " + solutionB.peek());
            isSovl = true;
        }
    }

    private void addBoard(Stack<Board> board, MinPQ<FindNode> minPQ) {
        FindNode node = minPQ.min();
        while (node.pre != null) {
            solutionB.push(node.board);
//            System.out.println("IN BANG:" + node.pre.board);
            node = node.pre;
        }
        solutionB.push(node.board);
//        System.out.println("IN BANG:" + node.board);
    }

    // is the initial board solvable? (see below)
    public boolean isSolvable() {
        return isSovl;
    }

    private void init(Board board, MinPQ<FindNode> findNodesPQ) {
        isSovl = false;
        FindNode init = new FindNode(board, null);
//        System.out.println(init.board);
        System.out.println();
        FindNode init2 = new FindNode(board.twin() , null);
//        System.out.println("BANG 2: " + init2.board);
        findNodesPQ.insert(init);
        findNodesPQ.insert(init2);
    }

    // min number of moves to solve initial board; -1 if unsolvable
    public int moves() {
        if (!isSovl) {
            return -1;
        }
        return moves;
    }

    // sequence of boards in a shortest solution; null if unsolvable
    public Iterable<Board> solution() {
        if (!isSovl) {
            return null;
        } else return solutionB;
    }

    public static void main(String[] args) {

        // create initial board from file
        In in = new In(args[0]);
        int n = in.readInt();
        int[][] tiles = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                tiles[i][j] = in.readInt();
        Board initial = new Board(tiles);
        System.out.println(initial.toString());
        // solve the puzzle
        Solver solver = new Solver(initial);

        // print solution to standard output
        if (!solver.isSolvable())
            StdOut.println("No solution possible");
        else {
            StdOut.println("Minimum number of moves = " + solver.moves());
            for (Board board : solver.solution())
                StdOut.println(board);
        }
    }

}
