package JA07Workshop.L01SmartArray;

import java.util.function.Consumer;

public class SmartArray {

    private int[] data;
    private int size;
    private int capacity;

    public SmartArray() {
        this.size = 0;
        this.capacity = 4;
        this.data = new int[capacity];
    }

    public void add(int element) {
        if (this.size == this.capacity) {
            grow();
        }
        this.data[size] = element;
        this.size++;
    }

    private void grow() {
        this.capacity *= 2;
        int[] tempData = new int[this.capacity];
        for (int i = 0; i < this.size; i++) {
            tempData[i] = this.data[i];
        }
        this.data = tempData;
    }

    public int get(int index) {
        checkIndex(index);
        return this.data[index];
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("Invalid index!");
        }
    }

    public int remove(int index) {
        checkIndex(index);
        int temp = this.data[index];
        for (int i = index; i < this.size - 1; i++) {
            this.data[i] = this.data[i + 1];
        }
        this.data[this.size - 1] = 0;
        this.size--;

        if (this.size <= this.capacity / 4) {
            shrink();
        }
        return temp;
    }

    private void shrink() {
        this.capacity /= 2;
        int[] tempData = new int[this.capacity];
        for (int i = 0; i < this.size; i++) {
            tempData[i] = this.data[i];
        }
        this.data = tempData;
    }

    public void add(int index, int element) {
        checkIndex(index);
        if (this.size == this.capacity) {
            grow();
        }
        int lastElement = this.data[this.size - 1];
        for (int i = this.size - 1; i > index; i--) {
            this.data[i] = this.data[i - 1];

        }
        this.data[this.size] = lastElement;
        this.size++;
        this.data[index] = element;
    }

    public boolean contains(int element) {
        for (int i = 0; i < this.size; i++) {
            if (this.data[i] == element) {
                return true;
            }
        }
        return false;
    }

    public void forEach(Consumer<Integer> consumer) {
        for (int i = 0; i < this.size; i++) {
            consumer.accept(this.data[i]);
        }
    }

    public int size() {
        return this.size;
    }
}