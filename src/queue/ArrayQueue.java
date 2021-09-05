package queue;

import java.util.NoSuchElementException;

public class ArrayQueue<E> {

    private E[] queue;
    private int front;
    private int back;

    public ArrayQueue(int capacity) {
        queue = (E[]) new Object[capacity];
    }

    public void add(E elem) {
        if (back == queue.length) {
            E[] newArray = (E[]) new Object[2 * queue.length];
            System.arraycopy(queue, 0, newArray, 0, queue.length);
            queue = newArray;
        }

        queue[back] = elem;
        back++;
    }

    public E remove() {
        if (size() == 0) {
            throw new NoSuchElementException();
        }

        E elem = queue[front];
        queue[front] = null;
        front++;
        if (size() == 0) {
            front = 0;
            back = 0;
        }

        return elem;
    }

    public E peek() {
        if (size() == 0) {
            throw new NoSuchElementException();
        }

        return queue[front];
    }

    public int size() {
        return back - front;
    }

    public void print() {
        for (int i = front; i < back; i++) {
            System.out.println(queue[i]);
        }
    }
}
