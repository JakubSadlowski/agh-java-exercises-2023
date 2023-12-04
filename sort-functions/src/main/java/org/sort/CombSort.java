package org.sort;

public class CombSort {
    public static int combSort(int[] array) {
        int n = array.length;
        int operations = 0;

        int gap = n;
        boolean swapped = true;

        while (gap != 1 || swapped) {
            gap = getNextGap(gap);
            swapped = false;

            for (int i = 0; i < n - gap; i++) {
                int j = i + gap;
                if (array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;

                    swapped = true;
                    operations++;
                }
            }
        }

        return operations;
    }

    private static int getNextGap(int gap) {
        gap = (gap * 10) / 13;
        return (gap < 1) ? 1 : gap;
    }
}
