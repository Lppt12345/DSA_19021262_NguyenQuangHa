package Coursera.EightPuzzle;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;
import java.util.Stack;

public class Board {

    private final int[][] titleN;
    // Chieu rong cua Board
    private final int size;
    private int row0;
    private int col0;

    private int position(int row, int col) {
        return row * size + col + 1;
    }

    // create a board from an n-by-n array of tiles,
    // where tiles[row][col] = tile at (row, col)
    public Board(int[][] tiles) {
        if (tiles == null) {
            throw new IllegalArgumentException("mang dua vao bi null");
        }
        this.size = tiles.length;
        titleN = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                titleN[i][j] = tiles[i][j];
                if (titleN[i][j] == 0) {
                    row0 = i;
                    col0 = j;
                }
            }
        }
    }

    // string representation of this board
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("" + size + "\n");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                stringBuilder.append(titleN[i][j] + " ");
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    // board kich thuoc n
    public int dimension() {
        return size;
    }

    // so o sai vi tri
    public int hamming() {
        int count = 0;
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                if (position(i, j) != titleN[i][j] && titleN[i][j] != 0) {
                    count++;
                }
            }
        }
        return count;
    }

    // Vi col row da bi giam 1 don vi nen number cung can giam cho can xung
    private int calculateDistance(int col, int row, int number) {
        int colC = Math.abs(col - (number - 1) / size);
        int rowC = Math.abs(row - (number - 1) % size);
        return colC + rowC;
    }

    // tong khoang cach tu cac o sai vi tri den dung vi tri
    public int manhattan() {
        int count = 0;
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                if (position(i, j) != titleN[i][j] && titleN[i][j] != 0) {
                    count += calculateDistance(i, j, titleN[i][j]);
                }
            }
        }
        return count;
    }


    // is this board the goal board?
    public boolean isGoal() {
        return hamming() == 0;
    }

    // check xem 2 bang co bang nhau ko
    public boolean equals(Object y) {
        if (y == null || getClass() != y.getClass()) {
            return false;
        }
        if (y == this) {
            return true;
        }
        return Arrays.deepEquals(((Board) y).titleN, this.titleN);

    }

    private int[][] cloneBoard(int[][] arr, int size) {
        int[][] clone = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                clone[i][j] = arr[i][j];
            }
        }
        return clone;
    }

    private void addneighbors(Stack<Board> board, int newRow, int newCol, int oldRow, int oldCol) {
        int[][] copyBoard = cloneBoard(titleN, size);
        int tmp = copyBoard[oldRow][oldCol];
        copyBoard[oldRow][oldCol] = copyBoard[newRow][newCol];
        copyBoard[newRow][newCol] = tmp;
        board.push(new Board(copyBoard));
    }

    // all neighboring boards
    public Iterable<Board> neighbors() {
        Stack<Board> neighB = new Stack<>();

        // add tren duoi phai trai
        if (row0 > 0) {
            addneighbors(neighB, row0 - 1, col0, row0, col0);
        }
        if (col0 > 0) {
            addneighbors(neighB, row0, col0 - 1, row0, col0);
        }
        if (row0 < size - 1) {
            addneighbors(neighB, row0 + 1, col0, row0, col0);
        }
        if (col0 < size - 1) {
            addneighbors(neighB, row0, col0 + 1, row0, col0);
        }
        return neighB;
    }

    // a board that is obtained by exchanging any pair of tiles
    public Board twin() {
        int[][] copyBoard = cloneBoard(titleN, size);
        for (int i = 0; i < size ;i++){
            for (int j = 0 ; j <size ;j++){
                if (copyBoard[i][j] != 0 && copyBoard[j][i] != 0 && j != i){
                    int tmp = copyBoard[i][j];
                    copyBoard[i][j] = copyBoard[j][i];
                    copyBoard[j][i] = tmp;
                    return new Board(copyBoard);
                }
            }
        }
        return null;
    }

    // unit testing (not graded)
    public static void main(String[] args) {
        int size = 3;
        int[][] arr = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                arr[i][j] = i * size + j + 1;
            }
        }
        arr[size - 1][size - 1] = 0;
        StdRandom.shuffle(arr);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(arr[i][j] + " ");
            }
        }
        Board test = new Board(arr);
        StdOut.println(test);
        StdOut.println(test.manhattan());
        StdOut.println(test.hamming());
        StdOut.println(test.isGoal());
//        Iterable<Board> neighbor = test.neighbors();
//        for (Board b : neighbor) {
//            StdOut.println(b);
//        }
        for (Board board : test.neighbors()){
            System.out.println(board);
        }
        StdOut.println("TWIN" + test.twin());
    }
}
