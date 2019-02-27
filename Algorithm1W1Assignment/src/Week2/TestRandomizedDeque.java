package Week2;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public class TestRandomizedDeque {

    private RandomizedQueue<Integer> test;

    @Before
    public void setUp() {
        test = new RandomizedQueue<>();
    }

    // TODO: Randomized Test?
    @Test
    public void queueNAndrandomdeque() {
        test.enqueue(4);
        test.enqueue(5);
        test.enqueue(6);
        test.enqueue(8);
        test.enqueue(9);
        test.enqueue(2);
        test.enqueue(1);
        test.enqueue(3);
        test.enqueue(7);
        test.enqueue(0);
        System.out.println(test.dequeue());
        System.out.println(test.dequeue());
        System.out.println(test.dequeue());
        System.out.println(test.dequeue());
        assertEquals(test.size(),6);
    }

    @Test
    public void testRandom() {
        test.enqueue(4);
        test.enqueue(5);
        test.enqueue(6);
        test.enqueue(8);
        test.enqueue(9);
        test.enqueue(2);
        test.enqueue(1);
        test.enqueue(3);
        test.enqueue(7);
        test.enqueue(0);
        assertEquals(test.size(),10);
        System.out.println(test.sample());
        System.out.println(test.sample());
        System.out.println(test.sample());
        System.out.println(test.sample());
        System.out.println(test.sample());
        assertEquals(test.size(),10);
    }

    @Test
    public void testIteratorNested() {
        test.enqueue(1);
        test.enqueue(2);
        test.enqueue(3);
        test.enqueue(4);
        test.enqueue(5);
        test.enqueue(6);
        test.enqueue(7);
        test.enqueue(8);
        test.enqueue(9);
        test.enqueue(0);
        Iterator iterator = test.iterator();
        while (iterator.hasNext()) {
            Iterator innerIt = test.iterator();
            while (innerIt.hasNext()) {
                System.out.println("Inner loop: ");
                System.out.println(innerIt.next());
            }
            System.out.println();
            System.out.print("Outer loop: ");
            System.out.println(iterator.next());
        }
    }



}
