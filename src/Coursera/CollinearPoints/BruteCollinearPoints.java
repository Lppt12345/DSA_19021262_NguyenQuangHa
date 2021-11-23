package Coursera.CollinearPoints;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.Arrays;

public class BruteCollinearPoints {

    private final ArrayList<LineSegment> line = new ArrayList<LineSegment>();

    // Tim tat ca doan thang chua 4 diem
    public BruteCollinearPoints(Point[] points) {
        int n = points.length;
        isValid(points, n);
        for (int i = 0; i < n - 3; i++) {
            for (int j = i + 1; j < n - 2; j++) {
                for (int k = j + 1; k < n - 1; k++) {
                    for (int z = k + 1; z < n; z++) {
                        double ij = points[i].slopeTo(points[j]);
                        double jk = points[i].slopeTo(points[k]);
                        double iz = points[i].slopeTo(points[z]);
                        if (ij == jk && ij == iz) {
                            line.add(new LineSegment(points[i], points[z]));
                        }
                    }
                }
            }
        }
    }

    /**
     * Kiem tra dong thoi sap xep mang dau vao
     *
     * @param points mang dau vao gom cac points
     */
    private void isValid(Point[] points, int size) {
        if (points == null) {
            throw new IllegalArgumentException("Mang dau vao bi null");
        }
        checkNull(points, size);
        checkDuplicate(points, size);
    }

    private void checkNull(Point[] points, int size) {
        for (int i = 0; i < size; i++) {
            if (points[i] == null) {
                throw new IllegalArgumentException("Co phan tu" + i + " bi null");
            }
        }
    }

    private void checkDuplicate(Point[] points, int size) {
        Arrays.sort(points);
        for (int i = 0; i < size - 1; i++) {
            if (points[i].compareTo(points[i + 1]) == 0) {
                throw new IllegalArgumentException("Phan tu bi trung nhau");
            }
        }
    }

    // So doan thang tim duoc
    public int numberOfSegments() {
        return line.size();
    }

    public LineSegment[] segments() {
        return line.toArray(new LineSegment[line.size()]);
    }

    public static void main(String[] args) {

        // read the n points from a file
        In in = new In(args[0]);
        int n = in.readInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            int x = in.readInt();
            int y = in.readInt();
            points[i] = new Point(x, y);
        }
        StdDraw.show();
        // print and draw the line segments
        BruteCollinearPoints collinear = new BruteCollinearPoints(points);
        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
        }
        System.out.println(collinear.numberOfSegments());
        StdDraw.show();
    }
}
