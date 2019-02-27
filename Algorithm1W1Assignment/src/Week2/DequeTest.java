import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;


public class DequeTest {

    private Deque<String> t;

    @Before
    public void setUp() {
        t = new Deque();

    }

    // TODO: check when deque is emptied and back to non-empty
    @Test
    public void testIsEmpty() {
        assertTrue(t.isEmpty());
    }

    @Test
    public void testSizeAddLast() {
        t. addLast("diu");
        t. addLast("diu");
        t. addLast("diu");
        assertEquals(t.size(), 3);
    }

    @Test
    public void testSizeAddFirst() {
        t. addFirst("diu");
        t. addFirst("diu");
        t. addFirst("diu");
        assertEquals(t.size(), 3);
    }

    @Test
    public void testSizeZero() {
        assertEquals(t.size(), 0);
    }

    @Test
    public void testSizeZeroOneZero() {
        assertEquals(t.size(), 0);
        t.addLast("one");
        assertEquals(t.size(), 1);
        t.removeFirst();
        assertEquals(t.size(), 0);
    }



    @Test
    public void testAddFirst() {
        t. addFirst("diu");
        assertEquals(t.size(), 1);
    }

    @Test
    public void testAddFirst2() {
        t.addFirst("diu");
        t.addFirst("last");
        assertEquals(t.removeFirst(), "last");
    }

    @Test
    public void testAddLast() {
        t. addLast("diu");
        t. addLast("diu");
        assertEquals(t.size(), 2);
    }

    @Test
    public void testAddLast2() {
        t. addLast("first");
        t. addLast("last");
        assertEquals(t.removeFirst(), "first");
        assertEquals(t.removeFirst(), "last");
        t. addLast("last");
        assertEquals(t.size(),1);
    }

    //TODO: multiple iterator used simultaneously

    @Test
    public void testIterator() {
        t.addFirst("1");
        t.addFirst("2");
        t.addFirst("3");
        t.addFirst("4");
        t.addFirst("5");
        for (String item : t) {
            System.out.println(item);
        }
    }

    @Test
    public void testIteratorNested() {
        t.addFirst("1");
        t.addFirst("2");
        t.addFirst("3");
        Iterator iterator = t.iterator();
        while (iterator.hasNext()) {
            Iterator innerIt = t.iterator();
            while (innerIt.hasNext()) {
                System.out.println("Inner loop: ");
                System.out.println(innerIt.next());
            }
            System.out.println();
            System.out.println(iterator.next());
        }
    }



}
