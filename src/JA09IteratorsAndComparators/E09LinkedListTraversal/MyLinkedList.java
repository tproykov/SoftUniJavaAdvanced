package JA09IteratorsAndComparators.E09LinkedListTraversal;

import java.util.Iterator;
import java.util.NoSuchElementException;

class MyLinkedList<T> implements Iterable<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    // Node inner class that holds the value and a pointer to the next node.
    private static class Node<T> {
        T value;
        Node<T> next;

        public Node(T value) {
            this.value = value;
            this.next = null;
        }
    }

    // Constructor initializes an empty list.
    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    // The add method appends the element at the end of the list.
    public void add(T element) {
        Node<T> newNode = new Node<>(element);
        if (head == null) { // List is empty
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    // The remove method removes the first occurrence of the element.
    public boolean remove(T element) {
        if (head == null) {
            return false; // List is empty.
        }

        // Check if the head needs to be removed.
        if ((head.value == null && element == null) || (head.value != null && head.value.equals(element))) {
            head = head.next;
            size--;
            if (head == null) { // If list becomes empty.
                tail = null;
            }
            return true;
        }

        // Traverse the list to find the element.
        Node<T> current = head;
        while (current.next != null) {
            if ((current.next.value == null && element == null) || (current.next.value != null && current.next.value.equals(element))) {
                // If the node to remove is the tail, update the tail pointer.
                if (current.next == tail) {
                    tail = current;
                }
                // Remove the node by skipping it.
                current.next = current.next.next;
                size--;
                return true;
            }
            current = current.next;
        }
        return false; // Element not found.
    }

    // Returns the current number of elements in the list.
    public int getSize() {
        return size;
    }

    // Returns an iterator that starts at the head of the list.
    @Override
    public Iterator<T> iterator() {
        return new MyLinkedListIterator();
    }

    // Inner class to implement the Iterator interface.
    private class MyLinkedListIterator implements Iterator<T> {
        private Node<T> current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T value = current.value;
            current = current.next;
            return value;
        }
    }
}
