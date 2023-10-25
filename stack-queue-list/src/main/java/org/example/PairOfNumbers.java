package org.example;

import java.util.Random;

public class PairOfNumbers {
    private double firstNumber;
    private double secondNumber;

    public PairOfNumbers() {
        this.firstNumber = randomNumberGenerator();
        this.secondNumber = randomNumberGenerator();
    }

    public double getFirstNumber() {
        return firstNumber;
    }

    public double getSecondNumber() {
        return secondNumber;
    }

    private double randomNumberGenerator(){
        Random r = new Random();
        double low = -100;
        double high = 100;
        double result = r.nextDouble(high-low) + low;
        return result;
    }
}
