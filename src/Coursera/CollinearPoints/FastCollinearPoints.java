//package Coursera.CollinearPoints;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class FastCollinearPoints {
    private final ArrayList<LineSegment> line = new ArrayList<>() ;

    // Tim tat ca doan thang chua 4 diem
    public FastCollinearPoints(Point[] points) {
        int n = points.length;
        // kiem tra va sap xep points
        isValid(points, n);
        List<String> checkDuplicate = new ArrayList<>();
        // Cho chay
        for (int i = 0; i < n; i++) {
            // Tao clone
            Point[] clone = Arrays.copyOf(points, n);
            Point[] check = new Point[4];
            Point tmp = clone[i];
            Comparator<Point> sort = clone[i].slopeOrder();
            Arrays.sort(clone, sort);
            int j = 0;
            while(j  <= n - 3 ) {
                if (sort.compare(clone[j], clone[j + 1]) == 0
                        && sort.compare(clone[j], clone[j + 2]) == 0
                ) {
                    check[0] = clone[j];
                    check[1] = clone[j + 1];
                    check[2] = clone[j + 2];
                    check[3] = tmp;
                    Arrays.sort(check);
                    LineSegment lineSegment = new LineSegment(check[0], check[3]);
                    if (!checkDuplicate.contains(lineSegment.toString())) {
                        checkDuplicate.add(lineSegment.toString());
                        line.add(lineSegment);
                    }
                    j += 3;
                }else {
                    j ++;
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

        // draw the points
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        for (Point p : points) {
            p.draw();
        }
        StdDraw.show();

        // print and draw the line segments
        FastCollinearPoints collinear = new FastCollinearPoints(points);
        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
            segment.draw();
        }
        System.out.println(collinear.numberOfSegments());
        StdDraw.show();
    }
}
