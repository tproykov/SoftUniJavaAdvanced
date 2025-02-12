package JA09IteratorsAndComparators.E02Collection;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListyIterator<T> implements Iterator<T>, Iterable<T> {

    private List<T> elements;
    private int currentIndex;

    @SafeVarargs
    public ListyIterator(T... elements) {
        
        this.elements = new ArrayList<>();
        for (T element : elements) {
            this.elements.add(element);
        }
        this.currentIndex = 0;
    }

    public ListyIterator(List<T> elements) {
        this.elements = new ArrayList<>(elements);
        this.currentIndex = 0;
    }

    public boolean move() {
        if (hasNext()) {
            currentIndex++;
            return true;
        }
        return false;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < elements.size() - 1;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return elements.get(currentIndex++);
    }

    public void print() {
        if (elements.isEmpty()) {
            throw new IllegalStateException("Invalid Operation!");
        }
        System.out.println(elements.get(currentIndex));
    }

    public void printAll() {
        if (elements.isEmpty()) {
            throw new IllegalStateException("Invalid Operation!");
        }
        String result = String.join(" ", elements.stream()
                .map(Object::toString)
                .toArray(String[]::new));
        System.out.println(result);
    }

    @Override
    public Iterator<T> iterator() {
        return this;
    }
}