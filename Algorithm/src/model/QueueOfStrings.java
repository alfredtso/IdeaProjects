package model;

public class QueueOfStrings {

    private Node first = null;
    private Node last = null;

    private class Node {
        String item;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public String deque() {
        String item = first.item;
        first = first.next; // For deleting the first node
        if (isEmpty()) last = null; // why tho
        return item;
    }

    public void enqueue(String item) {
        Node oldlast = last;
        Node last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) {
            first = last;
        } else {
            oldlast.next = last;
        }
    }

}
