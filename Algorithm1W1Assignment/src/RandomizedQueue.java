import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private Item[] queue;
    private int size;
    private int emptyslot;

    public RandomizedQueue() {
        queue = (Item[]) new Object[2];
        size = 0;
        emptyslot = 0;
    }

//    // TODO: return an independent iterator over items in random order
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
        private Item[] array = (Item[]) new Object[size];

        public RandomizedQueueIterator() {
            for (int i = 0 ; i < size; i++) {
                array[i] = (Item) queue[i];
            }
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
            int randomint = 0;
            Item result = null;
            while (result == null) {
                randomint = StdRandom.uniform(size);
                result = array[randomint];
            }
            array[randomint] = null;
            n--;
            return result;
        }
    }

//    // TODO: construct an empty randomized queue
    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private void resize(int newsize) {
        Item[] copy = (Item[]) new Object[newsize];
        if (size >= 0) System.arraycopy(queue, 0, copy, 0, size);
        queue = copy;
    }

    // TODO: Empty slot?
    public void enqueue(Item item) {
        if (item == null) throw new IllegalArgumentException();

        if (size == queue.length) {
            resize(2 * queue.length);
        }

        if (emptyslot == 0) {
            queue[size++] = item;
        } else {
            int j = 0;
            while (queue[j] != null) {
                j++;
            }
            queue[j] = item;
        }
    }

    public Item dequeue() {
        if (size == 0) throw new NoSuchElementException();

        Item result = null;
        int randomIndex = 0;

        while (result == null) {
            randomIndex = StdRandom.uniform(size);
            result = queue[randomIndex];
        }

        queue[randomIndex] = null;
        emptyslot++;
        size--;

        if (size > 0 && size == queue.length / 4 && emptyslot == 0) {
            resize(queue.length / 2);
        }

        return result;
    }

    public Item sample() {
        if (size == 0) throw new NoSuchElementException();

        int random = StdRandom.uniform(size);
        return queue[random];
    }
}

