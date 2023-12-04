package org.sort;

public class BubbleSort {
    public static int bubbleSort(int[] array) {
        int n = array.length;
        int operations = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    operations++;
                }
            }
        }
        return operations;
    }
}
