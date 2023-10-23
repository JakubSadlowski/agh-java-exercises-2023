package org.stack;

import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.List;

public class AssertUtils {
    public static void assertListsEqual(List<Integer> list1, List<Integer> list2) {
        String list1ToString = Arrays.toString(list1.toArray());
        String list2ToString = Arrays.toString(list2.toArray());
        Assertions.assertEquals(list1ToString, list2ToString, "Lists are different");
    }
}
