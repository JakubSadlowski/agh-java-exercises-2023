package org.sort;

public class InsertionSort {
    public static int insertionSort(int[] array) {
        int n = array.length;
        int operations = 0;

        for (int i = 1; i < n; i++) {
            int key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
                operations++;
            }
            array[j + 1] = key;
        }
        return operations;
    }
}
