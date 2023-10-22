package org.stack;

public class Main {
    public static void main(String[] args) {
        int[] sequence = {3, 6, 9, 12, 15, 18, 21, 24, 27, 30};
        int l = 2;

        StackImpl stack = new StackImpl();
        stack.selectMultiples(sequence, l);
        stack.printStack();
        stack = flipStack(stack);
        stack.printStack();
    }

    private static StackImpl flipStack(StackImpl stackImpl){
        StackImpl flippedStackImpl = new StackImpl();
        while (stackImpl.getTop() != null) {
            flippedStackImpl.push(stackImpl.getDataFromStack());
            stackImpl.pop();
        }
        return flippedStackImpl;
    }
    private static StackImpl flipStackByRecursion(StackImpl stackImpl, int n){
        int temp = stackImpl.getDataFromStack();
        stackImpl.pop();
        stackImpl.push(temp);
        return flipStackByRecursion(stackImpl, n - 1);
    }

    private static StackImpl removeFromStackByIndex(){
        return null;
    }
}