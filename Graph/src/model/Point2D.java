package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Point2D implements Comparable<Point2D> {

    private final double x;
    private final double y;
    // Compare two points by x-coordinate
    public static final Comparator<Point2D> X_ORDER = new XOrder();

    // Compare two points by y-coordinate
    public static final Comparator<Point2D> Y_ORDER = new YOrder();

    // Compare two points by polar radius

    private static final Point2D ORIGIN = new Point2D(0, 0);

    private Point2D(double x, double y) {
        if (Double.isInfinite(x) || Double.isInfinite(y)) throw new IllegalArgumentException("");
        if (Double.isNaN(x) || Double.isNaN(y)) throw new IllegalArgumentException("");
        if (x == 0.0) this.x = 0.0;
        else this.x = x;
        if (y == 0.0) this.y = 0.0;
        else this.y = y;
    }


    @Override
    public int compareTo(Point2D o) {
        if (this.y < o.y) return -1;
        if (this.y > o.y) return +1;
        if (this.x < o.x) return -1;
        if (this.x > o.x) return +1;
        return 0;
    }

    // XOrder
    private static class XOrder implements Comparator<Point2D> {
        public int compare(Point2D p, Point2D q) {
            if (p.x < q.x) return -1;
            if (p.x > q.x) return +1;
            return 0;
        }
    }

    // compare points according to their y-coordinate
    private static class YOrder implements Comparator<Point2D> {
        public int compare(Point2D p, Point2D q) {
            return (int) (p.x - q.x);
        }
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    public static void main(String[] args) {
        List<Point2D> pointsoflies = new ArrayList<>();
        Point2D point1 = new Point2D(1.0, 2.0);
        Point2D point2 = new Point2D(4.0, 2.0);
        Point2D point3 = new Point2D(7.0, 2.0);
        Point2D point4 = new Point2D(2.0, 2.0);
        pointsoflies.add(point1);
        pointsoflies.add(point2);
        pointsoflies.add(point3);
        pointsoflies.add(point4);
        XOrder testing = new XOrder();
        System.out.println("Before Sorting : " + pointsoflies);
        Collections.sort(pointsoflies, testing);
        System.out.println("After Sorting : " + pointsoflies);
    }

}