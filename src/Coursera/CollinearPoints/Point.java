//package Coursera.CollinearPoints;
import edu.princeton.cs.algs4.StdDraw;
import java.util.Comparator;

public class Point implements Comparable<Point> {
    // Toa do x,y
    private final int x;
    private final int y;


    /**
     * Khai bao bien.
     *
     * @param x Toa do x.
     * @param y Toa do y.
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Ve diem bang Stdraw
    public void draw() {
        StdDraw.point(x, y);
    }

    // draws the line segment from this point to that point
    public void drawTo(Point that) {
        StdDraw.line(this.x, this.y, that.x, that.y);
    }

    // string representation
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    // compare two points by y-coordinates, breaking ties by x-coordinates
    public int compareTo(Point that) {
        // Truong hop bang nhau
        if (this.x == that.x && this.y == that.y) {
            return 0;
        }
        // Lon hon neu y lon hon
        // 1 la this > that va nguoc lai
        if (this.y == that.y) {
            if (this.x - that.x > 0) return 1;
            else return -1;
        }
        if (this.y - that.y > 0) {
            return 1;
        } else return -1;
//        if (this.y == that.y) {
//            return Integer.compare(this.x, that.x);
//        } else {
//            return Integer.compare(this.y, that.y);
//        }
    }

    /**
     * Ham lay slope 2 diem (do doc)
     *
     * @param that diem so sanh
     * @return slope
     */
    public double slopeTo(Point that) {

        if (this.x == that.x && this.y == that.y) {
            return Double.NEGATIVE_INFINITY;
        }
        if (this.x == that.x) {
            return Double.POSITIVE_INFINITY;
        }
        if (this.y == that.y) {
            return 0;
        }
        return (double) (that.y - this.y) / (that.x - this.x);
    }

    // compare two points by slopes they make with this point
    // Tra ve Comparator dinh nghia sap xep cua point
    public Comparator<Point> slopeOrder() {
        return new SlopeCompare();
    }

    private class SlopeCompare implements Comparator<Point> {

        @Override
        public int compare(Point o1, Point o2) {
            double slopeO1 = Point.this.slopeTo(o1);
            double slopeO2 = Point.this.slopeTo(o2);
            if (slopeO1 > slopeO2) {
                return 1;
            }
            if (slopeO1 < slopeO2) {
                return -1;
            }
            return 0;
        }
    }

    // Main
    public static void main(String[] args) {
        Point p1 = new Point(1, 3);
        Point p2 = new Point(1, 3);
        Point p3 = new Point(4, 7);
        Point p4 = new Point(4, 7);
        Point p5 = new Point(0, 9);
        Point p6 = new Point(-2, 3);
        Point p7 = new Point(1, 4);
        System.out.println("So sanh bang nhau: " + p1.compareTo(p3));
        System.out.println("So sanh bang nhau: " + p1.compareTo(p2));
        System.out.println("So sanh bang nhau: " + p3.compareTo(p4));
        System.out.println("So sanh bang nhau: " + p1.compareTo(p4));
        System.out.println("So sanh bang nhau: " + p6.compareTo(p7));
        System.out.println("So sanh slope: " + p1.slopeTo(p2));
        System.out.println("So sanh slope: " + p1.slopeTo(p6));
        System.out.println("So sanh slope: " + p2.slopeTo(p5));
        System.out.println("So sanh slope: " + p1.slopeTo(p7));

    }
}