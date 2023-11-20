package org.list;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Queue {
    private static final int INDEX_NOT_DEFINED = -1;
    private PairOfNumbers[] elements;
    private int index;

    public Queue(int maxSize) {
        this.elements = new PairOfNumbers[maxSize];
        index = elements.length;
    }

    public int size() {return elements.length;}

    public boolean isEmpty() {
        return index == elements.length;
    }

    public boolean isFull() {
        return index == 0;
    }

    public void add(PairOfNumbers data) {
        if (isFull()) {
            throw new IllegalStateException("Queue reached its maximum size =" + elements.length);
        }
        elements[--index] = data;
    }

    public double sum(){
        double sum = 0;
        for (int i = 0; i < elements.length; i++) {
            sum += elements[i].getFirstNumber() + elements[i].getSecondNumber();
        }
        System.out.println("\nSum of the numbers in the queue: " + sum);
        return sum;
    }

    void sort() {
        int n = elements.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (elements[j].sumPair() > elements[j + 1].sumPair()) {
                    PairOfNumbers temp = elements[j];
                    elements[j] = elements[j + 1];
                    elements[j + 1] = temp;
                }
            }
        }
    }

    public PairOfNumbers poll() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return elements[index--];
    }

    private int getElementsIndex(int index) {
        return elements.length - 1 - index;
    }

    public List<PairOfNumbers> getElements() {
        if (isEmpty()) {
            return Collections.emptyList();
        }
        return List.of(Arrays.copyOfRange(elements, index, elements.length));
    }

    public void printQueue(){
        System.out.print("Sorted queue of pairs = [");
        for (int i = 0; i < elements.length; i++) {
            System.out.print("[" + elements[i].getFirstNumber() + ", " + elements[i].getSecondNumber() + "], ");
        }
        System.out.print("]");
    }
}


