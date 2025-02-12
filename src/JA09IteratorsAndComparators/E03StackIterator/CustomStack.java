package JA09IteratorsAndComparators.E03StackIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class CustomStack<Integer> implements Iterable<Integer> {
    
    private List<Integer> elements;

    public CustomStack() {
        this.elements = new ArrayList<>();
    }

    public void push(Integer element) {
        elements.add(element);
    }

    public Integer pop() {
        if (elements.isEmpty()) {
            throw new IllegalStateException("No elements");
        }
        return elements.remove(elements.size() - 1);
    }

    @Override
    public Iterator<Integer> iterator() {
        return new CustomIterator();
    }

    private class CustomIterator implements Iterator<Integer> {
        private int currentIndex;

        public CustomIterator() {
            this.currentIndex = elements.size() - 1; // Start from the top of the stack
        }

        @Override
        public boolean hasNext() {
            return currentIndex >= 0;
        }

        @Override
        public Integer next() {
            return elements.get(currentIndex--);
        }
    }
}