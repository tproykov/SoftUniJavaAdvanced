package JA07Workshop.E01CustomLinkedList;

public class Main {

    public static void main(String[] args) {

        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();

        doublyLinkedList.addFirst(1);
        doublyLinkedList.addFirst(2);
        doublyLinkedList.addFirst(3);
        doublyLinkedList.addFirst(4);
        doublyLinkedList.addFirst(5);


        doublyLinkedList.forEach(System.out::println);








    }
}