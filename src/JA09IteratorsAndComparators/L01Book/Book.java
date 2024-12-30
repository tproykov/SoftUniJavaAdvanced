package JA09IteratorsAndComparators.L01Book;

import java.util.ArrayList;
import java.util.List;

public class Book implements Comparable<Book> {

    private String title;
    private int year;
    private List<String> authors;

    public Book(String title, int year, String... authors) {
        setTitle(title);
        setYear(year);
        setAuthors(authors);
    }

    public String getTitle() {
        return title;
    }

    private void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    private void setYear(int year) {
        this.year = year;
    }

    public List<String> getAuthors() {
        return authors;
    }

    private void setAuthors(String... authors) {
        this.authors = new ArrayList<>();
        for (String author : authors) {
            this.authors.add(author);
        }
    }

    public int compareTo(Book otherBook) {

        int result = this.title.compareTo(otherBook.getTitle());
        if (result == 0) {
            result = Integer.compare(this.year, otherBook.getYear());
        }
        return result;
    }
}