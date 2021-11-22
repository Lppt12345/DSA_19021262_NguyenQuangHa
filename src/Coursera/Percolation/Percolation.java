package Coursera.Percolation;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;
public class Percolation {
    public int size;
    public boolean [][] grid;
    public int countOpen;
    private final WeightedQuickUnionUF wqu;
    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n){
        if (n <= 0) {
            throw new IllegalArgumentException("n phai lon hon 0");
        }
        this.size = n;
        this.grid = new boolean[n][n];
        this.countOpen = 0;
        this.wqu = new WeightedQuickUnionUF(n * n + 2);
    }



    // opens the site (row, col) if it is not open already
    public void open(int row, int col){
        if (!isValid(row, col ,this.size)){
            throw new IllegalArgumentException("Hang cot khong hop le");
        };
        if (isOpen(row, col)) {
            return;
        }
        if (!isOpen(row, col)) {
            grid[row -1 ][col -1 ] = true;
            countOpen++;
        }


    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col){
        if (!isValid(row, col ,this.size)){
            throw new IllegalArgumentException("Hang cot khong hop le");
        };
        return grid[row-1][col-1];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col){
        if (!isValid(row, col ,this.size)){
            throw new IllegalArgumentException("Hang cot khong hop le");
        };


    }

    // returns the number of open sites
    public int numberOfOpenSites(){

    }

    // does the system percolate?
    public boolean percolates(){

    }

    public boolean isValid (int row, int col, int size){
        if (row <= 0 || row > size) {
            return false;
        }
        if (col <= 0 || col > size) {
            return false;
        }
        return true;
    }

    // test client (optional)
    public static void main(String[] args){

    }

}
