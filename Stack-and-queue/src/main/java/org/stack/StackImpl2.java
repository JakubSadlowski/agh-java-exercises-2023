package org.stack;

public class StackImpl2 implements Stack<Integer> {
    private static final int EMPTY_STACK_INDEX = -1;
    private final Integer[] array;
    private int index = EMPTY_STACK_INDEX;

    public StackImpl2(int stackSize) {
        array = new Integer[stackSize];
    }

    @Override
    public Integer push(Integer item) {
        return null;
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
    public void push(int data) {
        array[index++] = data;
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
}
