package model;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Stack<Item> implements Iterable<Item> {

    private Node<Item> first; // Top of the stack
    private int size;

    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    public Stack() {
        first = null;
        size = 0;
    }

    public void push(Item item) {
        Node<Item> oldfirst = first;
        first = new Node<Item>();
        first.item = item;
        first.next = oldfirst;
        size++;
    }

    public Item pop() {
        if (!isEmpty()) throw new NoSuchElementException("Stack underflow");
        Item result = first.item;
        first = first.next;
        size--;
        return result;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    }


    private Item peek() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        return first.item;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item: this) {
            s.append(item);
            s.append(' ');
        }
        return s.toString();
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<Item> iterator() {
        return new ListIterator<Item>(first);
    }

    private class ListIterator<Item> implements Iterator<Item> {

        private Node<Item> current;

        private ListIterator(Node<Item> first) {
            current = first;
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
            return current != null;
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
            Item item = current.item;
            current = current.next;
            return item;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args) {
        Stack<String> testing = new Stack<>();
        Scanner scan = new Scanner(System.in);
        while (System.in != null) {
            String item = scan.next();
            testing.push(item);
            System.out.println(testing.size());
        }
    }
}
