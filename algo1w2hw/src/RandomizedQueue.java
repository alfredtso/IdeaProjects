import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private Item[] queue;
    private int size;

    public RandomizedQueue() {
        queue = (Item[]) new Object[2];
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    // oldsize > newsize
    private void sizeDown(int newsize, int oldsize) {
        Item[] copy = (Item[]) new Object[newsize];

        int oldid = 0;
        int newid = 0;

        while (oldid < oldsize) {
            if (queue[oldid] != null) {
                copy[newid] = queue[oldid];
                oldid++;
                newid++;
            } else {
                oldid++;
            }
        }

        queue = copy;
    }

    private void sizeUp(int newsize) {
        assert newsize >= size;

        Item[] temp = (Item[]) new Object[newsize];
        for (int i = 0; i < size; i++) {
            temp[i] = queue[i];
        }
        queue = temp;
    }

    public void enqueue(Item item) {
        if (item == null) throw new IllegalArgumentException();

        if (size == queue.length) {
            sizeUp(2 * queue.length);
        }

        for (int i = 0; i < size + 1; i++) {
            if (queue[i] == null) {
                queue[i] = item;
                size++;
                break;
            }
        }

        StdRandom.shuffle(queue);
    }

    public Item dequeue() {
        if (size == 0) throw new NoSuchElementException();

        Item result = null;

        for (int i = 0; i < queue.length; i++) {
            if (queue[i] != null) {
                result = queue[i];
                queue[i] = null;
                size--;
                break;
            }
        }

        // resize when needed
        if (size > 0 && size == queue.length / 4) {
            sizeDown(queue.length / 2, queue.length);
        }

        return result;
    }

    public Item sample() {
        if (size == 0) throw new NoSuchElementException();

        Item result = null;

        // shuffle everytime sample
        StdRandom.shuffle(queue);

        for (int i = 0; i < queue.length; i++) {
            if (queue[i] != null) {
                result = queue[i];
                break;
            }
        }
        return result;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<Item> iterator() {
        return new RandomizedQueueIterator<>();
    }

    private class RandomizedQueueIterator<Item> implements Iterator<Item> {

        private int n;
        private Item[] array = (Item[]) new Object[queue.length];

        public RandomizedQueueIterator() {
            for (int i = 0; i < queue.length; i++) {
                array[i] = (Item) queue[i];
            }
            StdRandom.shuffle(array);
            n = size;
        }
        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            return  n != 0;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public Item next() {
            if (n == 0) throw new NoSuchElementException();

            Item result = null;

            for (int i = 0; i < array.length; i++) {
                if (array[i] != null) {
                    result = array[i];
                    array[i] = null;
                    n--;
                    break;
                }
            }

            return result;
        }
    }

}

