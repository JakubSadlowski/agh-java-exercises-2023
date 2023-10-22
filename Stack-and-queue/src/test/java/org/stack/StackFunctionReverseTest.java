package org.stack;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.stack.AssertUtils.assertListsEqual;

class StackFunctionReverseTest {
    @Test
    void functionReverseWithMethodA() {
        // Given
        Stack<Integer> stack = new PointerStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        // When
        Stack<Integer> reversedStack = StackFunctions.reverseStackMethodA(stack);

        // Then
        assertListsEqual(reversedStack.getElements(), List.of(4, 3, 2, 1));
    }

    @Test
    void functionReverseWithMethodB() {
        // Given
        Stack<Integer> stack = new PointerStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        // When
        Stack<Integer> reversedStack = StackFunctions.reverseStackMethodB(stack);

        // Then
        assertListsEqual(reversedStack.getElements(), List.of(4, 3, 2, 1));
    }

    @Test
    void functionReverseEmptyStackWithMethodA() {
        // Given
        Stack<Integer> stack = new PointerStack();

        // When
        Stack<Integer> reversedStack = StackFunctions.reverseStackMethodA(stack);

        // Then
        assertListsEqual(reversedStack.getElements(), List.of());
    }
}