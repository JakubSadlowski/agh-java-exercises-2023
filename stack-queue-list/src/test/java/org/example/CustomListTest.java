package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CustomListTest {
    @Test
    void testList() {
        //Given
        CustomList list = new CustomList(10);

        //Then
        Assertions.assertEquals(11, list.getSize());
    }
}