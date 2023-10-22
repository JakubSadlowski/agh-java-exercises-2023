package org.stack;

import org.junit.jupiter.api.Assertions;

import java.util.List;

public class AssertUtils {
    public static void assertListsEqual(List<Integer> list1, List<Integer> list2) {
        Assertions.assertEquals(list1.size(), list2.size(), "Lists are of different size");
        for (int i = 0; i < list1.size(); i++) {
            Assertions.assertEquals(list1.get(i), list2.get(i), "List elements at index i=" + i + " are different");
        }
    }
}
