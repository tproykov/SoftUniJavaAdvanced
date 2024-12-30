package JA09IteratorsAndComparators.L01Book;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

//        Exercise 1: ---------------------------------------------------------------------------------
//        Book bookOne = new Book("Animal Farm", 2003, "George Orwell");
//        Book bookThree = new Book("The Documents in the Case", 2002);
//        Book bookTwo = new Book("The Documents in the Case", 1930, "Dorothy Sayers", "Robert Eustace");
//
//        List<Book> books = new ArrayList<>();
//        books.add(bookOne);
//        books.add(bookTwo);
//        books.add(bookThree);
//
//        Exercise 2: -----------------------------------------------------------------------------------
        Book book1 = new Book("Harry Potter", 2000);
        Book book2 = new Book("Pragmatics of Human Communication", 2000,
                "Watzlawick", "Beavin", "Jackson");
        Library library = new Library(book1, book2);

        for (Book book : library) {
            System.out.println(book);
        }
    }
}