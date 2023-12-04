package org.sort;

public class SelectionSort {
    public static int selectionSort(int[] array) {
        int n = array.length;
        int operations = 0;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }

                operations++;
            }

            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
        return operations;
    }
}
