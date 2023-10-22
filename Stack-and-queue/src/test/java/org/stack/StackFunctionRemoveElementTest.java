package org.stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.stack.AssertUtils.assertListsEqual;

class StackFunctionRemoveElementTest {
    @Test
    void testRemoveCase1() {
        // Given
        ArrayStack stack = new ArrayStack(4);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        // When
        StackFunctions.removeElementFromStackArrayImpl(stack, 2);

        // Then
        assertListsEqual(stack.getElements(), List.of(1, 2, 4));
    }

    @Test
    void testRemoveFirst() {
        // Given
        ArrayStack stack = new ArrayStack(4);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        // When
        StackFunctions.removeElementFromStackArrayImpl(stack, 0);

        // Then
        assertListsEqual(stack.getElements(), List.of(2, 3, 4));
    }

    @Test
    void testRemoveLast() {
        // Given
        ArrayStack stack = new ArrayStack(4);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        // When
        StackFunctions.removeElementFromStackArrayImpl(stack, 3);

        // Then
        assertListsEqual(stack.getElements(), List.of(1, 2, 3));
    }

    @Test
    void testRemoveExceedingBoundary() {
        // Given
        ArrayStack stack = new ArrayStack(4);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        // When
        Assertions.assertThrows(IllegalArgumentException.class, () -> StackFunctions.removeElementFromStackArrayImpl(stack, -1));
        Assertions.assertThrows(IllegalArgumentException.class, () -> StackFunctions.removeElementFromStackArrayImpl(stack, 5));
        Assertions.assertThrows(IllegalArgumentException.class, () -> StackFunctions.removeElementFromStackArrayImpl(stack, 4));
    }

}