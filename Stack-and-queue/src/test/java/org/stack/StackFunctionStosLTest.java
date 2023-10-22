package org.stack;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.stack.AssertUtils.assertListsEqual;

class StackFunctionStosLTest {

    @Test
    void functionStosLWithEvenNumber() {
        // When
        Stack<Integer> stackWithEvenNumbers = StackFunctions.stosL(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, 2);

        // Then
        assertListsEqual(stackWithEvenNumbers.getElements(), List.of(2, 4, 6, 8));
    }

    @Test
    void functionStosLWithEmptyInput() {
        // When
        Stack<Integer> stackWithEvenNumbers = StackFunctions.stosL(new int[]{}, 2);

        // Then
        assertListsEqual(stackWithEvenNumbers.getElements(), List.of());
    }

    @Test
    void functionStosLWithUnevenNumbers() {
        // When
        Stack<Integer> stackWithEvenNumbers = StackFunctions.stosL(new int[]{1, 3, 5, 7}, 2);

        // Then
        assertListsEqual(stackWithEvenNumbers.getElements(), List.of());
    }

    @Test
    void functionStosLWithAllMatching() {
        // When
        Stack<Integer> stackWithEvenNumbers = StackFunctions.stosL(new int[]{1, 2, 3, 10, 5, 7}, 1);

        // Then
        assertListsEqual(stackWithEvenNumbers.getElements(), List.of(1, 2, 3, 10, 5, 7));
    }


}