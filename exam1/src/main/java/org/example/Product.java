package org.example;

public class Product {
    private String name;
    private double price;
    private int calorificValue;

    public Product(String name, double price, int calorificValue) {
        this.name = name;
        this.price = price;
        this.calorificValue = calorificValue;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getCalorificValue() {
        return calorificValue;
    }
}
