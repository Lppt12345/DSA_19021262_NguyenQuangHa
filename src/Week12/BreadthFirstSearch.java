package Week12;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BreadthFirstSearch {

    private Queue<Integer> queue = new LinkedList<>();
    private int[][] grid;
    private int[] distance;
    private boolean[] visted;
    private int nodes;
    private int edges;

    public BreadthFirstSearch(int nodes, int edges) {
        this.nodes = nodes;
        this.edges = edges;
        grid = new int[nodes][nodes];
        distance = new int[nodes];
        visted = new boolean[nodes];
    }



    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        int numberOfQuestions = scanner.nextInt();

        for (int i = 0; i < numberOfQuestions; i++) {
            int nodes = scanner.nextInt();
            int edge = scanner.nextInt();

            BreadthFirstSearch bfs = new BreadthFirstSearch(nodes, edge);

            for (int j = 0; j < edge; j++) {
                int nodeF = scanner.nextInt() - 1;
                int nodeL = scanner.nextInt() - 1;

                bfs.grid[nodeF][nodeL] = 1;
                bfs.grid[nodeL][nodeF] = 1;
            }

            int s = scanner.nextInt() - 1;

            shortest_reach(bfs, s);
        }
    }

    private static void shortest_reach(BreadthFirstSearch bfs, int s) {
        bfs.visted[s] = true;
        bfs.queue.add(s);
        while (!bfs.queue.isEmpty()){
            int node = bfs.queue.remove();
            for (int i = 0; i < bfs.nodes; i++) {
                if (bfs.grid[node][i] == 1 && !bfs.visted[i]){
                    bfs.visted[i] = true;
                    bfs.queue.add(i);
                    bfs.distance[i] = bfs.distance[node] + 6;
                }
            }
        }

        for (int i = 0; i < bfs.nodes; i++) {
            if (i == s)
                continue;
            if (bfs.visted[i])
                System.out.print(bfs.distance[i] + " ");
            else
                System.out.print("-1 ");
        }

        System.out.println();
    }
}