package model;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

import javax.sound.sampled.Line;
import java.util.Arrays;
import java.util.Comparator;

public class FastCollinearPoints {

    private Point[] points;
    private int N;
    private LineSegment[] result;

    public FastCollinearPoints(Point[] points) {

        // throw exception if arg to the constructor contains a repeated pt
        if (points == null || Arrays.asList(points).contains(null)) {
            throw new IllegalArgumentException();
        }

        this.points = points.clone();
        int N = this.points.length;
        int linelength = 0;
        LineSegment[] lineSegments = new LineSegment[N];
        Point[] temp = new Point[N];
        System.arraycopy(points, 0, temp, 0, N);

        for (Point pt : points) {

            Arrays.sort(temp, pt.slopeOrder());

//            System.out.println("Sorted by slopeOrder to: " + pt);
//            for (Point res : temp) {
//                System.out.println(res);
//            }
//            System.out.println();

            for (int i = 1; i + 2 < N; i++) {
//                System.out.println("Loop: i = " + i);
                if ((pt.slopeTo(temp[i]) == pt.slopeTo(temp[i + 1])) &&
                        (pt.slopeTo(temp[i + 1]) == pt.slopeTo(temp[i + 2]))) {
                    int k = 2;
                    while (pt.slopeTo(temp[i + k]) == pt.slopeTo(temp[i])) {
                        k++;
                        if (i + k >= N) break;
                    }
                    // Sort subarray using y breaktie with x excluding i+k th
//                    System.out.println("Found same slope at " + i + " til " + (i + k));
//                    Arrays.sort(temp, i, i + k, Point::compareTo);
//                    System.out.println("Sorting subarray...");
                    // approach 1 take all out
//                    Point[] sortByX = new Point[i+k-1];
                    if (pt.compareTo(temp[i]) <= -1) {
                        lineSegments[linelength++] = new LineSegment(pt, temp[i + k - 1]);
                        break;
                    }

//                    for (Point res : temp) {
//                        System.out.println(res);
//                    }
//                    System.out.println();
                }
//                System.out.println("Done Loop: " + i);
            }

//            for (LineSegment line : lineSegments) {
//                System.out.println("Line Segments: ");
//                System.out.println(line);
//            }
//            System.out.println();

        }
        result = new LineSegment[linelength];
        System.arraycopy(lineSegments, 0, result, 0, linelength);

//        for (LineSegment line : result) {
//            System.out.println("Line Segments: ");
//            System.out.println(line);
//        }
//        System.out.println();
    }

    public LineSegment[] segments() {
        return result;
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
        StdDraw.show();

    }

}
