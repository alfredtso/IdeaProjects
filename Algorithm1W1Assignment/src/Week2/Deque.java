package Week2;

import com.sun.xml.internal.bind.v2.TODO;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    // TODO: decide on the data implementation based on memory performance
    // TODO: find out how to check memory usage
    /*
    *support each op in constant worse-case time, use space proportional
    *to current items and max 48n + 192 bytes,
    *iterator implementation must support each ops in constant worst-case time*/
    private int size;
    private Node sentinel;

    private class Node {
        Item item;
        Node next;
        Node previous;
    }

    public Deque() {
        sentinel = new Node();
        sentinel.next = null;
        sentinel.previous = null;
        size = 0;
    }

    public boolean isEmpty(){
        return (sentinel.next == null && sentinel.previous == null);
    }

    public int size() {
        return size;
    }

    // TODO: refactor this duplicate code
    public void addFirst(Item item) {
        if (item == null) throw new IllegalArgumentException();

        Node newfirst = new Node();

        if (isEmpty()) {
            newfirst.next = sentinel;
            sentinel.previous = newfirst;
        } else {
            // point to oldfirst
            newfirst.next = sentinel.next;
            // oldfirst pre point to newfirst;
            sentinel.next.previous = newfirst;
        }
        // newfirst pre point to sent;
        newfirst.previous = sentinel;

        // sentinel point to newfirst;
        sentinel.next = newfirst;

        // put item in the new node
        newfirst.item = item;

        size++;
    }

    // TODO: refactor this duplicate code
    public void addLast(Item item) {
        if (item == null) throw new IllegalArgumentException();
        // mirror addFirst

        Node newlast = new Node();

        if (isEmpty()) {
            newlast.previous = sentinel;
            sentinel.next = newlast;
        } else {
            newlast.previous = sentinel.previous;
            sentinel.previous.next = newlast;
        }

        newlast.next = sentinel;
        sentinel.previous = newlast;

        newlast.item = item;
        size++;
    }

    public Item removeFirst() {
        if (isEmpty()) throw new NoSuchElementException();
        Item result = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.previous = sentinel;
        size--;
        return result;
    }

    public Item removeLast() {
        if (isEmpty()) throw new NoSuchElementException();
        Item result = sentinel.previous.item;
        sentinel.previous = sentinel.previous.previous;
        sentinel.previous.next = sentinel;
        size--;
        return result;
    }


    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator<Item> implements Iterator<Item> {

        private Node current = sentinel;

        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            return current.next.item != null;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item result = (Item) current.next.item;
            current = current.next;
            return result;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

    }
}
