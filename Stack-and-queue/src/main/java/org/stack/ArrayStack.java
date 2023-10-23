package org.stack;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayStack implements Stack<Integer> {
    private static final int EMPTY_STACK_INDEX = -1;
    private final Integer[] array;
    private int index = EMPTY_STACK_INDEX;

    public ArrayStack(int stackSize) {
        array = new Integer[stackSize];
    }

    @Override
    public Integer push(Integer element) {
        if (isMaxStackCapacityReached()) {
            throw new IllegalStateException("Unable to add element to stack. Stack reached max of its capacity=" + array.length);
        }
        array[++index] = element;
        return element;
    }

    @Override
    public Integer pop() {
        if (empty()) {
            throw new IllegalStateException("Stack is empty");
        }
        Integer value = array[index];
        index--;
        return value;
    }

    @Override
    public Integer peek() {
        if (empty()) {
            return null;
        }
        return array[index];
    }

    @Override
    public boolean empty() {
        return index == EMPTY_STACK_INDEX;
    }

    @Override
    public int size() {
        return index + 1;
    }

    @Override
    public List<Integer> getElements() {
        if (empty()) {
            return Collections.emptyList();
        }
        Integer[] stackArray = Arrays.copyOf(array, index + 1);
        return List.of(stackArray);
    }

    @Override
    public Stack<Integer> reverse() {
        Stack<Integer> result = new ArrayStack(index + 1);
        for (int i = index; i >= 0; i--) {
            result.push(array[i]);
        }
        return result;
    }

    @Override
    public void print(){
        for(Integer element: array){
            System.out.print(element + ", ");
        }
    }

    public Integer remove(int index) {
        if (index < 0 || index >= array.length) {
            throw new IllegalArgumentException("Method argument index=" + index + " is invalid because it exceeds stack boundaries.");
        }
        Integer result = array[index];
        for (int i = index; i < this.index; i++) {
            array[i] = array[i + 1];
        }
        this.index--;
        return result;
    }

    private boolean isMaxStackCapacityReached() {
        return index >= array.length - 1;
    }
}
