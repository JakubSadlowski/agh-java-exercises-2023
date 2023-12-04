package org.sort;

public class ShellSort {
    public static int shellSort(int[] array) {
        int n = array.length;
        int operations = 0;

        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int temp = array[i];
                int j;

                for (j = i; j >= gap && array[j - gap] > temp; j -= gap) {
                    array[j] = array[j - gap];
                    operations++;
                }

                array[j] = temp;
            }
        }
        return operations;
    }
}
