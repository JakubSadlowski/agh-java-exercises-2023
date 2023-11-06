package org.list;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Queue {
    private static final int INDEX_NOT_DEFINED = -1;
    private Integer[] elements;
    private int index;

    public Queue(int maxSize) {
        this.elements = new Integer[maxSize];
        index = elements.length;
    }

    public boolean isEmpty() {
        return index == elements.length;
    }

    public boolean isFull() {
        return index == 0;
    }

    public void add(int data) {
        if (isFull()) {
            throw new IllegalStateException("Queue reached its maximum size =" + elements.length);
        }
        elements[--index] = data;
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
        for (int i = elements.length - 1; i >= 0; i--) {
            if (elements[i] == value) {
                return getElementsIndex(i);
            }
        }
        return INDEX_NOT_DEFINED;
    }

    public int remove(int index) {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        } else if (index < 0 || index >= elements.length) {
            throw new IllegalArgumentException("Method argument index=" + index + " is invalid because it exceeds stack boundaries.");
        }
        int elementsIndex = getElementsIndex(index);
        Integer result = elements[elementsIndex];
        for (int i = elementsIndex; i > 0; i--) {
            elements[i] = elements[i - 1];
        }
        elements[this.index] = 0;
        this.index++;
        return result;
    }

    private int getElementsIndex(int index) {
        return elements.length - 1 - index;
    }

    public List<Integer> getElements() {
        if (isEmpty()) {
            return Collections.emptyList();
        }
        return List.of(Arrays.copyOfRange(elements, index, elements.length));
    }

    @Override
    public String toString() {
        return Arrays.toString(elements);
    }
}


