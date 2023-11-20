package org.stack;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Queue3 implements Queue {
    private static final int INDEX_NOT_DEFINED = -1;
    private Integer[] elements;
    private int index = INDEX_NOT_DEFINED;

    public Queue3(int maxSize) {
        this.elements = new Integer[maxSize];
    }

    public boolean isEmpty() {
        return index == INDEX_NOT_DEFINED;
    }

    public boolean isFull() {
        return index >= elements.length - 1;
    }

    public void add(int data) {
        if (isFull()) {
            throw new IllegalStateException("Queue reached its maximum size =" + elements.length);
        }
        index++;
        for (int i = index; i > 0; i--) {
            elements[i] = elements[i - 1];
        }
        elements[0] = data;
    }

    public Integer poll() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return elements[index--];
    }

    public int indexOf(int value) {
        if (isEmpty()) {
            return INDEX_NOT_DEFINED;
        }
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] == value) {
                return i;
            }
        }
        return INDEX_NOT_DEFINED;
    }

    public int remove(int index) {
        if (index < 0 || index >= elements.length) {
            throw new IllegalArgumentException("Method argument index=" + index + " is invalid because it exceeds stack boundaries.");
        }
        Integer result = elements[index];
        for (int i = index; i < elements.length - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[elements.length - 1] = 0;
        this.index--;
        return result;
    }


    public List<Integer> getElements() {
        if (isEmpty()) {
            return Collections.emptyList();
        }
        return List.of(Arrays.copyOf(elements, index + 1));
    }

    @Override
    public String toString() {
        return Arrays.toString(elements);
    }
}

