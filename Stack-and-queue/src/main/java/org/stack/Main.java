package org.stack;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        exercise001();
        exercise002A();
        exercise002B();
        exercise003();
    }

    private static void exercise003() {
        System.out.println("\n\nExercise 003: Starting stack = {1, 2, 3, 4}, removing element in index 2");
        ArrayStack arrayStack = new ArrayStack(4);
        arrayStack.push(1);
        arrayStack.push(2);
        arrayStack.push(3);
        arrayStack.push(4);
        StackFunctions.removeElementFromStackArrayImpl(arrayStack, 2);
        System.out.print(String.format("Result: %s", arrayStack));

    }

    private static void exercise002B() {
        System.out.println("\n\nExercise 002B: Starting stack = {1, 2, 3, 4}");
        Stack<Integer> stack2 = new PointerStack();
        stack2.push(1);
        stack2.push(2);
        stack2.push(3);
        stack2.push(4);
        Stack<Integer> reversedStack = StackFunctions.reverseStackMethodB(stack2);
        System.out.print(String.format("Result: %s", reversedStack));
    }

    private static void exercise002A() {
        System.out.println("\n\nExercise 002A: Starting stack = {1, 2, 3, 4}");
        Stack<Integer> stack1 = new PointerStack();
        stack1.push(1);
        stack1.push(2);
        stack1.push(3);
        stack1.push(4);
        Stack<Integer> reversedStack = StackFunctions.reverseStackMethodA(stack1);
        System.out.print(String.format("Result: %s", reversedStack));
    }

    private static void exercise001() {
        System.out.println("Exercise 001: Starting numbers in array = {1, 2, 3, 4}, given number l: 2");
        Stack<Integer> resultStack = StackFunctions.stosL(new int[]{1, 2, 3, 4}, 2);
        System.out.print(String.format("Result: %s", resultStack));
    }
}