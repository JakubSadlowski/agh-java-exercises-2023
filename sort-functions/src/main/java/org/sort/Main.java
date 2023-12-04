package org.sort;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        //Size 10
        System.out.println("Array of size 10\n");
        int[] array1 = generateRandomArray(10, 1, 10);
        printOperationsCountersForSorts(array1);
        measureSortingTime(array1);

        //Size 1000
        System.out.println("\nArray of size 1000\n");
        int[] array2 = generateRandomArray(1000, 1, 1000);
        printOperationsCountersForSorts(array2);
        measureSortingTime(array2);

        //Size 10000
        System.out.println("\nArray of size 10000\n");
        int[] array3 = generateRandomArray(10000, 10, 10000);
        printOperationsCountersForSorts(array3);
        measureSortingTime(array3);
    }

    private static void printOperationsCountersForSorts(int[] array) {
        int bubbleSortOperations = BubbleSort.bubbleSort(array.clone());
        System.out.println("BubbleSort operations: " + bubbleSortOperations);

        int insertionSortOperations = InsertionSort.insertionSort(array.clone());
        System.out.println("InsertionSort operations: " + insertionSortOperations);

        int selectionSortOperations = SelectionSort.selectionSort(array.clone());
        System.out.println("SelectionSort operations: " + selectionSortOperations);

        int combSortOperations = CombSort.combSort(array.clone());
        System.out.println("CombSort operations: " + combSortOperations);

        int shellSortOperations = ShellSort.shellSort(array.clone());
        System.out.println("ShellSort operations: " + shellSortOperations);
    }

    private static int[] generateRandomArray(int size, int minValue, int maxValue) {
        int[] randomArray = new int[size];
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            randomArray[i] = random.nextInt(maxValue - minValue + 1) + minValue;
        }

        return randomArray;
    }

    private static void measureSortingTime(int[] array){
        long startTime = System.nanoTime();
        //bubbleSort
        BubbleSort.bubbleSort(array.clone());
        long endTime = System.nanoTime();
        long elapsedTime = (endTime - startTime)/1000;
        System.out.println("\nBubbleSort sorting time: " + elapsedTime + "ms");

        //InsertionSort
        startTime = System.nanoTime();
        InsertionSort.insertionSort(array.clone());
        endTime = System.nanoTime();
        elapsedTime = (endTime - startTime)/1000;
        System.out.println("InsertionSort sorting time: " + elapsedTime + "ms");

        //SelectionSort
        startTime = System.nanoTime();
        SelectionSort.selectionSort(array.clone());
        endTime = System.nanoTime();
        elapsedTime = (endTime - startTime)/1000;
        System.out.println("SelectionSort sorting time: " + elapsedTime + "ms");

        //CombSort
        startTime = System.nanoTime();
        CombSort.combSort(array.clone());
        endTime = System.nanoTime();
        elapsedTime = (endTime - startTime)/1000;
        System.out.println("CombSort sorting time: " + elapsedTime + "ms");

        //ShellSort
        startTime = System.nanoTime();
        ShellSort.shellSort(array.clone());
        endTime = System.nanoTime();
        elapsedTime = (endTime - startTime)/1000;
        System.out.println("ShellSort sorting time: " + elapsedTime + "ms");
    }
}