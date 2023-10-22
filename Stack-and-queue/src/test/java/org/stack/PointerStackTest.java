package org.stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PointerStackTest {
    private Stack<Integer> stack;

    @BeforeEach
    void beforeEach() {
        stack = new PointerStack();
    }

    @Test
    void checkEmptyStack() {
        // Then
        Assertions.assertEquals(0, stack.size());
        Assertions.assertTrue(stack.empty());
    }

    @Test
    void addingOneElementToStack() {
        // When
        stack.push(356);

        // Then
        Assertions.assertEquals(356, stack.peek());
        Assertions.assertEquals(1, stack.size());
        Assertions.assertFalse(stack.empty());
    }

    @Test
    void addingSeveralElementsToStack() {
        // When
        stack.push(1);
        stack.push(2);
        stack.push(999);

        // Then
        Assertions.assertEquals(3, stack.size());
        Assertions.assertEquals(999, stack.peek());
        Assertions.assertFalse(stack.empty());
    }

    @Test
    void addingAndRemovingElementsFromStack() {
        // When
        stack.push(1);
        stack.push(2);
        stack.push(999);
        int valueForPop1 = stack.pop();
        int valueForPop2 = stack.pop();
        int valueForPop3 = stack.pop();

        // Then
        Assertions.assertEquals(999, valueForPop1);
        Assertions.assertEquals(2, valueForPop2);
        Assertions.assertEquals(1, valueForPop3);
        Assertions.assertEquals(0, stack.size());
        Assertions.assertNull(stack.peek());
        Assertions.assertTrue(stack.empty());
    }

    @Test
    void removingElementFromEmptyStack() {
        // When Then
        Assertions.assertThrows(IllegalStateException.class, stack::pop);
    }

}