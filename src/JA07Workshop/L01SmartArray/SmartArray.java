package JA07Workshop.L01SmartArray;

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
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + this.size);
        }
    }

    public int size() {
        return this.size;
    }
}
