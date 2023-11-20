package org.list;

import java.util.*;

public class Main {
    public static void main(String[] args){
        List<PairOfNumbers> list = SolutionFunctions.createList();
        SolutionFunctions.sumNumbersInListAndAddAverage(list);
        Stack stack = SolutionFunctions.addToStack(list);
        SolutionFunctions.removeMaxElementFromStack(stack);
        SolutionFunctions.addToQueueAndSort(stack);
    }

}