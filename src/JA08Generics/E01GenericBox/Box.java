package JA08Generics.E01GenericBox;

public class Box<T extends Comparable<T>> implements Comparable<Box<T>> {

    private T element;

    public Box(T element) {
        this.element = element;
    }

    @Override
    public String toString() {
        return String.format("%s: %s", this.element.getClass().getName(), this.element);
    }

    @Override
    public int compareTo(Box<T> o) {
        return this.element.compareTo(o.element);
    }
}