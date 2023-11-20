package org.list;

import java.util.ArrayList;
import java.util.List;

public class SolutionFunctions {
    /**
     * Stwórz listę składającą się z 10 elementów (wygenerowanych jak powyżej). Po utworzeniu
     * listy napisz funkcję, która wypisze sumę wszystkich elementów znajdujących się w liście i na
     * jej koniec doda dodatkowy – 11 element – który jest średnią wszystkich elementów w liscie
     */

    public static List<PairOfNumbers> createList(){
        List<PairOfNumbers> list = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            list.add(new PairOfNumbers());
        }
        printList(list);
        return list;
    }

    public static List<PairOfNumbers> sumNumbersInListAndAddAverage(List<PairOfNumbers> list){
        double sum = 0;
        for (PairOfNumbers element:list) {
            sum += element.getFirstNumber() + element.getSecondNumber();
        }
        double average = sum / 10;
        System.out.println("\nSum of the numbers in the list: " + sum);
        list.add(new PairOfNumbers(average, average));
        return list;
    }

    private static void printList(List<PairOfNumbers> list){
        System.out.print("List of pairs = [");
        for (PairOfNumbers element:list) {
            System.out.print("[" + element.getFirstNumber() + ", " + element.getSecondNumber() + "], ");
        }
        System.out.print("]");
    }

    /**
     * Powyższą listę przenieś do utworzonego przez siebie stosu. Napisz funkcję, która ze stosu
     * usunie element maksymalny. Jeżeli elementów maksymalnych jest więcej niż jeden, usuń
     * pierwszy napotkany
     */

    public static Stack addToStack(List<PairOfNumbers> list){
        Stack stack = new Stack(11);
        for (PairOfNumbers element:list) {
            stack.push(element);
        }
        return stack;
    }

    public static Stack removeMaxElementFromStack(Stack stack){
        List<PairOfNumbers> list = stack.getElements();
        PairOfNumbers maxPair = stack.peek();
        for (PairOfNumbers element:list) {
            if (element.getFirstNumber() + element.getSecondNumber() > maxPair.getFirstNumber() + maxPair.getSecondNumber()) {
                maxPair = element;
            }
        }
        stack.remove(stack.getIndex(maxPair));
        return stack;
    }

    /**
     * Tak zmodyfikowany stos przenieś do kolejki. Stosując kolejkę napisz funkcję, która policzy
     * sumę wszystkich par liczb i ułoży je w kolejności rosnącej.
     */

    public static Queue addToQueueAndSort(Stack stack){
        Queue queue = new Queue(10);
        for(int i = 0; i < 10; i++){
            queue.add(stack.pop());
        }
        queue.sum();
        queue.sort();
        queue.printQueue();
        return queue;
    }

}
