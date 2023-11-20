package org.list;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Stack {
    private static final int EMPTY_STACK_INDEX = -1;
    private final PairOfNumbers[] array;
    private int index = EMPTY_STACK_INDEX;

    public Stack(int stackSize) {
        array = new PairOfNumbers[stackSize];
    }

    public PairOfNumbers push(PairOfNumbers element) {
        if (isMaxStackCapacityReached()) {
            throw new IllegalStateException("Unable to add element to stack. Stack reached max of its capacity=" + array.length);
        }
        array[++index] = element;
        return element;
    }

    public PairOfNumbers pop() {
        if (empty()) {
            throw new IllegalStateException("Stack is empty");
        }
        PairOfNumbers value = array[index];
        index--;
        return value;
    }

    public PairOfNumbers peek() {
        if (empty()) {
            return null;
        }
        return array[index];
    }

    public boolean empty() {
        return index == EMPTY_STACK_INDEX;
    }

    public int size() {
        return index + 1;
    }

    public List<PairOfNumbers> getElements() {
        if (empty()) {
            return Collections.emptyList();
        }
        PairOfNumbers[] stackArray = Arrays.copyOf(array, index + 1);
        return List.of(stackArray);
    }

    public int getIndex(PairOfNumbers pair){
        int index = -1;
        for(int i = 0; i < this.index; i++){
            if((pair.getFirstNumber() == array[i].getFirstNumber()) && (pair.getSecondNumber() == array[i].getSecondNumber())){
                index = i;
                break;
            }
        }
        return index;
    }
    public PairOfNumbers remove(int index) {
        if (index < 0 || index >= array.length) {
            throw new IllegalArgumentException("Method argument index=" + index + " is invalid because it exceeds stack boundaries.");
        }
        PairOfNumbers result = array[index];
        for (int i = index; i < this.index; i++) {
            array[i] = array[i + 1];
        }
        this.index--;
        return result;
    }

    private boolean isMaxStackCapacityReached() {
        return index >= array.length - 1;
    }

    @Override
    public String toString() {
        return Arrays.toString(getElements().toArray());
    }
}
