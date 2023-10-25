package org.example;

public class CustomList {
    private PairOfNumbers[] array;
    private double sum = sumElementsInList();

    public CustomList(int size) {array = new PairOfNumbers[size + 1];}

    public int getSize(){
        return array.length;
    }

    public double getSum() {
        return sum;
    }

    private double sumElementsInList(){
        double sum = 0;
        for (PairOfNumbers element: array) {
            sum += element.getFirstNumber() + element.getSecondNumber();
        }
        return sum;
    }

    private double averageofElementsInList(){
        return sum / (array.length - 1);
    }

    public void addAverageOfElementsToList(){
        PairOfNumbers pairOfAverages = new PairOfNumbers(averageofElementsInList(), averageofElementsInList());
        array[array.length - 1] = pairOfAverages;
    }
}
