package JA07Workshop.E01CustomLinkedList;

import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class DoublyLinkedList {

    class Node {
        int element;
        Node next;
        Node prev;

        public Node(int element) {
            this.element = element;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public void addFirst(int element) {
        Node newNode = new Node(element);
        if (head == null) {
            this.head = newNode;
            this.tail = newNode;
        }
        else {
            newNode.next = this.head;
            this.head.prev = newNode;
            this.head = newNode;
        }
        this.size++;
    }

    public void addLast(int element) {
        Node newNode = new Node(element);
        if (head == null) {
            this.head = newNode;
            this.tail = newNode;
        }
        else {
            newNode.prev = this.tail;
            this.tail.next = newNode;
            this.tail = newNode;
        }
        this.size++;
    }

    public int get(int index) {
        checkIndex(index);

        Node current;
        if (index <= this.size / 2) {
            current = this.head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        }
        else {
            current = this.tail;
            for (int i = this.size - 1; i > index; i--) {
                current = current.prev;
            }
        }
        return current.element;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("This is invalid index!");
        }
    }

    public int removeFirst() {
        checkIfEmpty();
        int element = this.head.element;
        this.head = this.head.next;

        if (this.head == null) {
            this.tail = null;
        }
        else {
            this.head.prev = null;
        }

        this.size--;
        return element;
    }

    public int removeLast() {
        checkIfEmpty();
        int element = this.tail.element;
        this.tail = this.tail.prev;

        if (this.tail == null) {
            this.head = null;
        }
        else {
            this.tail.next = null;
        }

        this.size--;
        return element;
    }

    private void checkIfEmpty() {
        if (this.head == null) {
            throw new NoSuchElementException("The list is empty!");
        }
    }

    public void forEach(Consumer<Integer> consumer) {
        Node currentNode = this.head;

        while (currentNode != null) {
            consumer.accept(currentNode.element);
            currentNode = currentNode.next;
        }
    }

    public int[] toArray() {
        int[] array = new int[this.size];
        Node currentNode = this.head;
        for (int i = 0; i < this.size; i++) {
            array[i] = currentNode.element;
            currentNode = currentNode.next;
        }
        return array;
    }
}