package JA09IteratorsAndComparators.E09LinkedListTraversal;

import java.util.Iterator;
import java.util.NoSuchElementException;

class MyLinkedList<T> implements Iterable<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    private static class Node<T> {

        T value;
        Node<T> next;

        public Node(T value) {
            this.value = value;
            this.next = null;
        }
    }

    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void add(T element) {

        Node<T> newNode = new Node<>(element);

        if (head == null) {
            head = newNode;
        } else {
            tail.next = newNode;
        }

        tail = newNode;
        size++;
    }

    public boolean remove(T element) {

        if (head == null) {
            return false;
        }

        if ((head.value == null && element == null) || (head.value != null && head.value.equals(element))) {
            head = head.next;
            size--;
            if (head == null) {
                tail = null;
            }
            return true;
        }

        Node<T> current = head;

        while (current.next != null) {
            if ((current.next.value == null && element == null)
                    || (current.next.value != null && current.next.value.equals(element))) {

                if (current.next == tail) {
                    tail = current;
                }

                current.next = current.next.next;
                size--;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public int getSize() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyLinkedListIterator();
    }

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
