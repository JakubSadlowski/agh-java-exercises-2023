package org.stack;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Queue {
    private Integer[] elements;
    private int front;
    private int rear;
    private int maxSize;
    private int currentSize;

    public Queue(int maxSize) {
        this.maxSize = maxSize;
        elements = new Integer[maxSize];
        front = 0;
        rear = -1;
        currentSize = 0;
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public boolean isFull() {
        return currentSize == maxSize;
    }

    public void insert(int data) {
        if (!isFull()) {
            if (rear == maxSize - 1) {
                rear = -1;
            }
            elements[++rear] = data;
            currentSize++;
        } else {
            System.out.println("Kolejka jest pełna.");
        }
    }

    public int remove() {
        if (!isEmpty()) {
            int temp = elements[front++];
            if (front == maxSize) {
                front = 0;
            }
            currentSize--;
            return temp;
        } else {
            System.out.println("Kolejka jest pusta.");
            return -1;
        }
    }

    public List<Integer> getElements() {
        if (isEmpty()) {
            return Collections.emptyList();
        }
        Integer[] queueCopy = Arrays.copyOf(elements, currentSize);
        return List.of(queueCopy);
    }

    public void deleteElement(int x) {
        int tempFront = front;
        boolean found = false;
        for (int i = 0; i < currentSize; i++) {
            if (elements[tempFront] == x) {
                found = true;
                break;
            }
            tempFront = (tempFront + 1) % maxSize;
        }
        if (found) {
            int count = 0;
            int tempRear = rear;
            for (int i = 0; i < currentSize; i++) {
                if (elements[tempFront] != x) {
                    elements[count] = elements[tempFront];
                    count++;
                }
                tempFront = (tempFront + 1) % maxSize;
            }
            rear = (rear - 1 + maxSize) % maxSize;
            currentSize = count;
        } else {
            System.out.println("Element " + x + " nie istnieje w kolejce.");
        }
    }
}

