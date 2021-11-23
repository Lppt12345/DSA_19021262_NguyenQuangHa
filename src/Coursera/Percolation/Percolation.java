package Coursera.Percolation;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private final int size;
    private boolean[][] grid;
    private int countOpen;
    private final int top;
    private final int bottom;
    private final WeightedQuickUnionUF wqu;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("n phai lon hon 0");
        }
        this.size = n;
        this.grid = new boolean[n][n];
        this.countOpen = 0;
        this.top = n * n + 1;
        this.bottom = n * n;
        // 2 don vi ao la tren va duoi
        // duoi n * n ; tren n*n +1
        this.wqu = new WeightedQuickUnionUF(n * n + 2);
    }

    // tim vi tri trong mang 1 chieu
    private int position(int row, int col) {
        return (row - 1) * size + col - 1;
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        int pos = position(row, col);
        if (!isValid(row, col, this.size)) {
            throw new IllegalArgumentException("Hang cot khong hop le");
        }
        if (isOpen(row, col)) {
            return;
        }
        if (!isOpen(row, col)) {
            grid[row - 1][col - 1] = true;
            countOpen++;
        }

        if (col > 1 && col <= size) {
            if (isOpen(row, col - 1)) {
                wqu.union(pos, pos - 1);
            }
        }

        if (col >= 1 && col < size) {
            if (isOpen(row, col + 1)) {
                wqu.union(pos, pos + 1);
            }
        }
        // lien ket no vs top
        if (row == 1) {
            wqu.union(pos, top);
        }
        // lk vs bottom
        if (row == size) {
            wqu.union(pos, bottom);
        }
        // Lien ket no vs cai tren no
        if (row >= 1 && row < size) {
            if (isOpen(row + 1, col)) {
                wqu.union(pos, pos + size);
            }
        }
        // Lien ket no vs cai duoi no
        if (row > 1 && row <= size) {
            if (isOpen(row - 1, col)) {
                wqu.union(pos, pos - size);
            }
        }
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        if (!isValid(row, col, this.size)) {
            throw new IllegalArgumentException("Hang cot khong hop le");
        }
        return grid[row - 1][col - 1];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        if (!isValid(row, col, this.size)) {
            throw new IllegalArgumentException("Hang cot khong hop le");
        }
        int pos = position(row, col);
        if (isOpen(row, col) && (wqu.find(pos) == wqu.find(top))) {
            return true;
        }
        return false;
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return this.countOpen;
    }

    // does the system percolate?
    public boolean percolates() {
        return wqu.find(bottom) == wqu.find(top);
    }

    private boolean isValid(int row, int col, int gridSize) {
        if (row <= 0 || row > gridSize) {
            return false;
        }
        if (col <= 0 || col > gridSize) {
            return false;
        }
        return true;
    }

    // test client (optional)
    public static void main(String[] args) {
        int n = 3;
        Percolation p = new Percolation(n);
        while (!p.percolates()) {
            int row = StdRandom.uniform(0, n) + 1;
            int col = StdRandom.uniform(0, n) + 1;
            System.out.println(row + "  " + col);
            p.open(row, col);
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    System.out.println("hang " + i + " va cot " + j + " isOPen ? : " + p.isOpen(i, j)
                            + "  " + p.isFull(i, j) + "  " + p.percolates() + " " + p.position(i, j));
                }
            }
        }
        System.out.print(p.numberOfOpenSites());
    }
}
