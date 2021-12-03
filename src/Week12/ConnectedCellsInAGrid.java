package Week12;

import java.util.Scanner;

public class ConnectedCellsInAGrid {
    static int[][] grid;
    static boolean[][] visited;
    static int N, M;


    static int count_connected(int [][] grid, int  row, int col) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[row].length){
            return 0;
        }
        if (grid[row][col] == 0){
            return 0;
        }
        int count = 1;
        grid[row][col] = 0;
        for (int r = row - 1; r <= row+1 ; r++){
            for (int c = col - 1; c <= col+1 ; c ++){
                if (c != col || r != row){
                    count += count_connected(grid, r , c);
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        grid = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                grid[i][j] = scanner.nextInt();
                visited[i][j] = false;
            }
        }
        int max = 0;
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                if (grid[i][j] == 0 || visited[i][j]) continue;
                int cnt = count_connected(grid, i, j);
                visited[i][j] = true;
                if (max < cnt) max = cnt;
            }
        }

        System.out.println(max);

    }
}