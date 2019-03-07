package test;

import org.junit.Before;
import model.Point;
import org.junit.Test;

import java.util.Comparator;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class PointTest {

    private Point test;

    @Before
    public void setUp() { test = new Point(0,0);}

    @Test
    public void slopeToPositive() {
        Point positivePoint = new Point(3,4);
        assertEquals(test.slopeTo(positivePoint), 3.0/4.0,0.001);
    }

    @Test
    public void slopeToNegative() {
        Point negativePoint = new Point(-3,4);
        assertEquals(test.slopeTo(negativePoint), -3.0/4.0,0.001);
    }

    @Test
    public void slopeToPositiveInf() {
        Point postiveInf = new Point(0,4);
        assertTrue(Double.isInfinite(test.slopeTo(postiveInf)));
    }
    @Test
    public void slopeToPositiveInfFalse() {
        Point postiveInf = new Point(-1,4);
        assertFalse(Double.isInfinite(test.slopeTo(postiveInf)));
    }

    @Test
    public void slopeToNegativeInf() {
        Point postiveInf = new Point(3,0);
        assertEquals(test.slopeTo(postiveInf), 0.0,0.001);
    }

    @Test
    public void slopeToNegativeInfFalse() {
        Point postiveInf = new Point(-1,4);
        assertFalse(Double.isInfinite(test.slopeTo(postiveInf)));
    }

    @Test
    public void compareToLTUsingY() {
        Point point = new Point(-1,4);
        assertEquals(test.compareTo(point), -1);
    }

    @Test
    public void compareToLTUsingX() {
        Point point = new Point(1,0);
        assertEquals(test.compareTo(point), -1);
    }


    @Test
    public void compareToEQ() {
        Point point = new Point(0,0);
        assertEquals(test.compareTo(point), 0);
    }

    @Test
    public void compareToGTUsingY() {
        Point point = new Point(0,-1);
        assertEquals(test.compareTo(point), 1);
    }

    @Test
    public void compareToGTUsingX() {
        Point point = new Point(-1,0);
        assertEquals(test.compareTo(point), 1);
    }

    @Test
    public void comparatorTest() {
        Point p1 = new Point(-1,0);
        Point p2 = new Point(-3,8);
        Comparator result = test.slopeOrder();
        assertEquals(result.compare(p1,p2), 1);
    }

    @Test
    public void comparatorEqual() {
        Point p1 = new Point(-1,8);
        Point p2 = new Point(-1,8);
        Comparator result = test.slopeOrder();
        assertEquals(result.compare(p1,p2), 0);
    }



}
