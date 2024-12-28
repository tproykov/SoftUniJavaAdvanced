package JA07Workshop.E01CustomLinkedList;

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
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("This is invalid index!");
        }

        Node currentNode = this.head;
        for (int i = 0; i < this.size; i++) {
            if (i == index) {
                break;
            }
            currentNode = currentNode.next;
        }
        return currentNode.element;
    }




}
