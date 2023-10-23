package org.stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.stack.AssertUtils.assertListsEqual;

class CustomLinkedListTest {

    @Test
    void testList() {
        //Given
        CustomLinkedList list = new CustomLinkedList();

        //When
        list.add(3);
        list.add(2);
        list.add(1);

        //Then
        assertListsEqual(List.of(3, 2, 1), list.getElements());
        Assertions.assertEquals(3, list.get(0));
        Assertions.assertEquals(2, list.get(1));
        Assertions.assertEquals(1, list.get(2));
    }

    @Test
    void testMergeWithListsOfEqualSize() {
        //Given
        CustomLinkedList list1 = new CustomLinkedList();
        CustomLinkedList list2 = new CustomLinkedList();

        //When
        list1.add(5).add(3).add(1);
        list2.add(6).add(4).add(2);
        list1.merge(list2);

        //Then
        assertListsEqual(List.of(5, 6, 3, 4, 1, 2), list1.getElements());
    }

    @Test
    void testMergeWithLongerList2() {
        //Given
        CustomLinkedList list1 = new CustomLinkedList();
        CustomLinkedList list2 = new CustomLinkedList();

        //When
        list1.add(5).add(3).add(1);
        list2.add(6).add(4).add(2).add(0).add(-1);
        list1.merge(list2);

        //Then
        assertListsEqual(List.of(5, 6, 3, 4, 1, 2, 0, -1), list1.getElements());
    }

    @Test
    void testMergeWithLongerList1() {
        //Given
        CustomLinkedList list1 = new CustomLinkedList();
        CustomLinkedList list2 = new CustomLinkedList();

        //When
        list1.add(5).add(3).add(1).add(0).add(-1);
        list2.add(6).add(4).add(2);
        list1.merge(list2);

        //Then
        assertListsEqual(List.of(5, 6, 3, 4, 1, 2, 0, -1), list1.getElements());
    }

}