package definition;

public class arrayQueue<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private int front = 0;
    private int rear = -1;
    private int size = 0;
    private int capacity = 0;
    private E[] data;

    public arrayQueue() {
        this(DEFAULT_CAPACITY);
    }

    public arrayQueue(int intialCapacity) {
        this.capacity = intialCapacity;

        this.data = (E[]) new Object[this.capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    // add an item at the rear of the queue
    public boolean offer(E item) {
        if (size == capacity) {
            reallocateQueue();
        }
        size++;
        rear = (rear + 1) % capacity;
        data[rear] = item;
        return true;
    }

    // return an item from the fron without removing it
    public E peek() {
        if (size == 0) {
            return null;
        } else {
            return data[front];
        }
    }

    // remove entry from front and return it
    public E poll() {
        if (size == 0) {
            return null;
        } else {
            E response = data[front];
            front = (front + 1) % capacity;
            size--;
            return response;
        }
    }

    private void reallocateQueue() {
        int newCapacity = this.capacity * 2;
        E[] newData = (E[]) new Object[newCapacity];
        int f = front;
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
            f = (f + 1) % capacity;
        }
        front = 0;
        rear = size - 1;
        this.capacity = newCapacity;
        data = newData;
    }

}
