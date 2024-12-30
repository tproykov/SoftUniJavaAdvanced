

import java.util.List;

public class ListyIterator<T> {

    private List<T> elements;
    private int currentIndex;

    public ListyIterator(T... elements) {
        this.elements = List.of(elements);
        this.currentIndex = 0;
    }

    public boolean move() {
        if (hasNext()) {
            this.currentIndex++;
            return true;
        }
        return false;
    }

    public boolean hasNext() {
        return this.currentIndex < this.elements.size() - 1;
    }

    public void print() {
        if (this.elements.isEmpty()) {
            throw new IllegalStateException("Invalid Operation!");
        }
        else {
            System.out.println(this.elements.get(this.currentIndex));
        }
    }
}