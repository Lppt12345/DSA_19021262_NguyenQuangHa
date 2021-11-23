//package Coursera.CollinearPoints;

public class LineSegment {
    private final Point p;
    private final Point q;

    /**
     * Ham khai bao doan thang
     *
     * @param p diem p
     * @param q diem q
     */
    public LineSegment(Point p, Point q) {
        if (p == null || q == null) {
            throw new NullPointerException("NUll");
        }
        if (q.equals(p)) {
            throw new IllegalArgumentException("2 diem p va q giong nhau");
        }
        this.p = p;
        this.q = q;
    }

    /**
     * Ve doan thang
     */
    public void draw() {
        p.drawTo(q);
    }

    public String toString() {
        return p + " ->" + q;
    }

    public int hashCode() {
        throw new UnsupportedOperationException("hashCode() khong ho tro");
    }
}
