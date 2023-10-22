package org.stack;

public class Main {
    public static void main(String[] args) {
        int[] sequence = {3, 6, 9, 12, 15, 18, 21, 24, 27, 30};
        int l = 2;

        Stack stack = new Stack();
        stack.selectMultiples(sequence, l);
        stack.printStack();
        stack = flipStack(stack);
        stack.printStack();
    }

    private static Stack flipStack(Stack stack){
        Stack flippedStack = new Stack();
        while (stack.getTop() != null) {
            flippedStack.push(stack.getDataFromStack());
            stack.pop();
        }
        return flippedStack;
    }
    private static Stack flipStackByRecursion(Stack stack, int n){
        int temp = stack.getDataFromStack();
        stack.pop();
        stack.push(temp);
        return flipStackByRecursion(stack, n - 1);
    }

    private static Stack removeFromStackByIndex(){
        return null;
    }
}