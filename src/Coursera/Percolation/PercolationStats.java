//package Coursera.Percolation;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {

    private final int trails;
    private final double[] results;
    private static final double confidence = 1.96;

    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        if (n <= 0) {
            throw new IllegalArgumentException("n nhap sai");
        }
        if (trials <= 0) {
            throw new IllegalArgumentException("trials nhap sai");
        }
        this.trails = trials;
        results = new double[trails];
        for (int i = 0; i < trials; i++) {
            Percolation percolation = new Percolation(n);
            int row, col;
            while (!percolation.percolates()) {
                row = StdRandom.uniform(0, n);
                col = StdRandom.uniform(0, n);
                percolation.open(row + 1, col + 1);
            }
            results[i] = (double) percolation.numberOfOpenSites() / (n * n);
        }
    }

    // sample mean of percolation threshold
    // tra ve do phan tram trung binh de dat dupc
    public double mean() {
        return StdStats.mean(results);
    }

    // sample standard deviation of percolation threshold
    // do lech chuan
    public double stddev() {
        return StdStats.stddev(results);
    }

    // low endpoint of 95% confidence interval
    // Tim cac gioi han tin cay tha[ hon 95
    public double confidenceLo() {
        double tmp = (confidence * stddev()) / Math.sqrt(trails);
        return mean() + tmp;
    }


    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        double tmp = (confidence * stddev()) / Math.sqrt(trails);
        return mean() - tmp;
    }

    // test client (see below)
    public static void main(String[] args) {
        PercolationStats test = new PercolationStats(50, 10);

        System.out.println("mean: = " + test.mean());
        System.out.println("stddev: = " + test.stddev());
        System.out.println("95% confidence interval: = " + test.confidenceLo() + ", " + test.confidenceHi());
    }
}
