package org.example;

public class Stack<T> {
    private T[] arr;
    private int top = -1;
    private int capacity = 10;

    public Stack() {
        this.arr = (T[]) new Object[capacity];
        this.top = -1;
    }

    public T peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty, cannot peek.");
            return null; // or throw an exception
        }
        return arr[top]; 

    }

    public void push(T type) {
        if (top == capacity - 1) {
            System.out.println("Stack is full, cannot push.");
            return;
        }
        arr[++top] = type;
    }

    public T pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty, cannot pop.");
            return null;
        }
        return arr[top--];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == capacity - 1;
    }

    public int size() {
        return top + 1;
    }

    public void clear() {
        top = -1;
    }
}
