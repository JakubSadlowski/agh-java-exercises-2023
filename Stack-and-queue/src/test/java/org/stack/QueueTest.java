package org.stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.stack.AssertUtils.assertListsEqual;

class QueueTest {
    @Test
    void addingSeveralElementsToQueue(){
        //Given
        Queue queue = new Queue(3);

        //When
        queue.insert(1);
        queue.insert(2);
        queue.insert(3);

        //Then
        assertListsEqual(queue.getElements(), List.of(1, 2, 3));
    }

    @Test
    void removingElementFromQueue(){
        //Given
        Queue queue = new Queue(3);

        //When
        queue.insert(1);
        queue.insert(2);
        queue.insert(3);
        queue.deleteElement(2);

        //Then
        assertListsEqual(queue.getElements(), List.of(1, 2));
    }
}