package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args){
        CustomList list = new CustomList(10);

        System.out.println("Sum of elements in list: " + list.getSum());
        list.addAverageOfElementsToList();
    }
}