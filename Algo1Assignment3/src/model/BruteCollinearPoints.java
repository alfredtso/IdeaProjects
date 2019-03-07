package model;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class BruteCollinearPoints {

    private int N;
    private Point[] points;

    public BruteCollinearPoints(Point[] points) {
        // throw exception if arg to the constructor contains a repeated pt
        if (points == null || Arrays.asList(points).contains(null)) {
            throw new IllegalArgumentException();
        }
        this.points = points.clone();
        this.N = points.length;
    }

    public int numberofSegments() {
        return this.segments().length;
    }

    public LineSegment[] segments() {
        // Arrays.sort(points, Point::compareTo);
        Arrays.sort(points, (a,b) -> {return a.compareTo(b);});
        for (Point pt : points) {
            System.out.println(pt);
        }
        LineSegment[] lines = new LineSegment[N-4];
        int t = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int r = j + 1; r < N; r++) {
                    if (points[i].slopeTo(points[j]) == points[j].slopeTo(points[r])) {
                        for (int s = r + 1; s < N; s++) {
                            if (points[j].slopeTo(points[r]) == points[r].slopeTo(points[s])) {
                                lines[t++] = new LineSegment(points[i], points[s]);
                            }
                        }
                    }
                }
            }
        }

        int res = 0;
        for (LineSegment line : lines) {
            if (line != null) {
                res++;
            }
        }
        LineSegment[] result = new LineSegment[res];

        for (int i = 0; i < res; i++) {
            result[i] = lines[i];
        }

        return result;
    }

    private void pointUnsorted() {
        for (Point pt : points) {
            System.out.println(pt);
        }
    }


    public static void main(String[] args) {

        In in = new In(args[0]);
        int n = in.readInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            int x = in.readInt();
            int y = in.readInt();
            points[i] = new Point(x, y);
        }

        BruteCollinearPoints collinearPoints = new BruteCollinearPoints(points);
        for (LineSegment i: collinearPoints.segments()) {
            System.out.println(i);
        }


        // draw the points
//        StdDraw.enableDoubleBuffering();
//        StdDraw.setXscale(0, 32768);
//        StdDraw.setYscale(0, 32768);
//        for (Point p : points) {
//            p.draw();
//        }
//        StdDraw.show();

        // print and draw the line segments
//        BruteCollinearPoints collinear = new BruteCollinearPoints(points);
//        for (LineSegment segment : collinear.segments()) {
//            StdOut.println(segment);
//            segment.draw();
//        }
//        StdDraw.show();
    }

}
