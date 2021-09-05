package stack;

import java.lang.reflect.Array;
import java.util.EmptyStackException;

public class ArrayStack<E> {

    private E[] elements;
    private int top;

    public ArrayStack(int capacity) {
        elements = (E[]) new Object[capacity];
    }

    public void push(E elem) {
        if (top == elements.length) {
            //inc size x2
            E[] newArray = (E[]) new Object[2 * elements.length];
            System.arraycopy(elements, 0, newArray, 0, elements.length);
            elements = newArray;
        }
        elements[top++] = elem;
    }

    public E pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        E elem = elements[--top];
        elements[top] = null;
        return elem;
    }

    public E peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return elements[top - 1];
    }

    public int size() {
        return top;
    }

    public boolean isEmpty() {
        return top == 0;
    }

    public void print() {
        for (int i = top - 1; i >= 0; i--) {
            System.out.println(elements[i]);
        }
    }
}
