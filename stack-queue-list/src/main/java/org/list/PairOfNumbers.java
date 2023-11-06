package org.list;

import java.util.Random;

public class PairOfNumbers {
    private double firstNumber;
    private double secondNumber;

    public PairOfNumbers() {
        this.firstNumber = randomNumberGenerator();
        this.secondNumber = randomNumberGenerator();
    }

    public PairOfNumbers(double firstNumber, double secondNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    public double getFirstNumber() {
        return firstNumber;
    }

    public double getSecondNumber() {
        return secondNumber;
    }

    public void setFirstNumber(double firstNumber) {
        this.firstNumber = firstNumber;
    }

    public void setSecondNumber(double secondNumber) {
        this.secondNumber = secondNumber;
    }

    public double sumPair(){
        return firstNumber + secondNumber;
    }

    private double randomNumberGenerator(){
        Random r = new Random();
        double low = -100;
        double high = 100;
        double result = r.nextDouble(high-low) + low;
        return result;
    }
}
