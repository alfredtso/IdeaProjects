import edu.princeton.cs.algs4.StdRandom;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class TestRandomizedDeque {

    private RandomizedQueue test;

    @Before
    public void setUp() {
        test = new RandomizedQueue<>();
    }

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
    public void graderTest2() {

        // Run for 10 times
        for (int k = 0; k < 10; k++) {

            test = new RandomizedQueue();

            System.out.println("Current Run: " + k);

            // fill in 50 items
            for (int i = 0; i < 50; i++) {
                test.enqueue(i);
            }
            System.out.println("Just enqueued 50 new items, current size: " + test.size());

            // choose a number between 0 - 50
            int randomRemoval = StdRandom.uniform(51);
            System.out.println("Number of items to be removed " + randomRemoval);

            // remove random number of items
            for (int j = 0; j < randomRemoval; j++) {
                Object result = test.dequeue();
                System.out.println("Removed item " + result );
                System.out.println("Current size " + test.size());
            }

            // check for size
            int finalsize = 50 - randomRemoval;
            System.out.println("Actual size: " + test.size());
            System.out.println("Size of testing " + finalsize);
            assertEquals(test.size(), 50-randomRemoval);

        }
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
