package org.stack;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.stack.AssertUtils.assertListsEqual;

class QueueTest {

    private static Queue createQueue(int size) {
        return new Queue2(size);
    }

    @Test
    void addingSeveralElementsToQueue() {
        //Given
        Queue queue = createQueue(3);

        //When
        queue.add(1);
        queue.add(2);
        queue.add(3);

        //Then
        assertListsEqual(List.of(3, 2, 1), queue.getElements());
    }


    @Test
    void removingElementInTheMiddleOfQueue() {
        //Given
        Queue queue = createQueue(3);

        //When
        queue.add(1);
        queue.add(2);
        queue.add(3);

        int index = queue.indexOf(2);
        if (index != -1) {
            queue.remove(index);
        }


        //Then
        assertListsEqual(List.of(3, 1), queue.getElements());
    }

    @Test
    void removingElementInsideOfQueue() {
        //Given
        Queue queue = createQueue(5);

        //When
        queue.add(1);
        queue.add(2);
        queue.add(5);
        queue.add(8);
        queue.add(3);

        int index = queue.indexOf(8);
        if (index != -1) {
            queue.remove(index);
        }

        //Then
        assertListsEqual(List.of(3, 5, 2, 1), queue.getElements());
    }

    @Test
    void removingFirstElementFromQueue() {
        //Given
        Queue queue = createQueue(3);

        //When
        queue.add(1);
        queue.add(2);
        queue.add(3);

        int index = queue.indexOf(1);
        if (index != -1) {
            queue.remove(index);
        }


        //Then
        assertListsEqual(List.of(3, 2), queue.getElements());
    }

    @Test
    void removingLastElementFromQueue() {
        //Given
        Queue queue = createQueue(3);

        //When
        queue.add(1);
        queue.add(2);
        queue.add(3);

        int index = queue.indexOf(3);
        if (index != -1) {
            queue.remove(index);
        }


        //Then
        assertListsEqual(List.of(2, 1), queue.getElements());
    }
}