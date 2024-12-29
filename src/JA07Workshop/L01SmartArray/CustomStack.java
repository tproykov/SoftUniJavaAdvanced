package JA07Workshop.L01SmartArray;

import java.util.NoSuchElementException;

public class CustomStack {
    private static final int INITIAL_CAPACITY = 4;
    private int capacity;
    private int size;
    private int[] items;

    public CustomStack() {
        this.capacity = INITIAL_CAPACITY;
        this.items = new int[this.capacity];
    }

    public int getSize() {
        return this.size;
    }

    public void push(int element) {
        if (this.size == this.capacity) {
            grow();
        }
        this.items[this.size] = element;
        this.size++;
    }

    private void grow() {
        this.capacity *= 2;
        int[] tempData = new int[this.capacity];
        for (int i = 0; i < this.size; i++) {
            tempData[i] = this.items[i];
        }
        this.items = tempData;
    }

    public int pop() {
        checkIfEmpty(this.items);
        int element = this.items[this.size - 1];
        this.size--;
        return element;
    }

    private void checkIfEmpty(int[] array) {
        if (this.size == 0) {
            throw new NoSuchElementException("CustomStack is empty");
        }
    }

    public void peek() {
        checkIfEmpty(this.items);
        int element = this.items[this.size - 1];
        return element;

    }





}
