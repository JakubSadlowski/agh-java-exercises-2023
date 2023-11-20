package org.stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

import static org.stack.AssertUtils.assertListsEqual;

class ArrayStackTest {
    private Stack<Integer> stack;

    private static Stream<Stack> stackImplementations() {
        return Stream.of(new ArrayStack(4), new PointerStack());
    }

    @BeforeEach
    void beforeEach() {
        stack = new ArrayStack(4);
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
        assertListsEqual(stack.getElements(), List.of(1, 2, 999));
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

    @Test
    void addingElementsExceedingSizeOfStack() {
        // When
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        // Then
        Assertions.assertThrows(IllegalStateException.class, () -> stack.push(5));
    }

    @Test
    void testReverse() {
        // Given
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        // When
        Stack<Integer> reversedStack = stack.reverse();

        // Then
        assertListsEqual(reversedStack.getElements(), List.of(4, 3, 2, 1));
    }

    @Test
    void testRemoveCase1() {
        // Given
        ArrayStack stack = new ArrayStack(4);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        // When
        stack.remove(2);

        // Then
        assertListsEqual(stack.getElements(), List.of(1, 2, 4));
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
        Assertions.assertThrows(IllegalArgumentException.class, () -> stack.remove(-1));
        Assertions.assertThrows(IllegalArgumentException.class, () -> stack.remove(5));
        Assertions.assertThrows(IllegalArgumentException.class, () -> stack.remove(4));
    }
}