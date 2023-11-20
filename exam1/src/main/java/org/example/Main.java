package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        //exercise 001
        List<Product> products = new ArrayList<>();
        products.add(new Product("Mleko", 25, 1000));
        products.add(new Product("Szynka", 11, 1200));
        products.add(new Product("Kiełbasa", 7, 1500));
        products.add(new Product("Jogurt", 4, 800));
        products.add(new Product("Jabłko", 3, 600));
        List<Product> removedProducts = removeRandomProduct(products);
        printProducts(removedProducts);

        int maxCallories = findMaxCalories(removedProducts);
        List<Product> removedCalloriesList = removeMaxCallories(removedProducts, maxCallories);
        printProducts(removedCalloriesList);

        //exercise 002
        List<Product> list1 = new ArrayList<>();
        list1.add(new Product("Mleko", 25, 1000));
        list1.add(new Product("Szynka", 11, 1200));
        list1.add(new Product("Kiełbasa", 7, 1500));
        list1.add(new Product("Jogurt", 4, 800));
        list1.add(new Product("Jabłko", 3, 600));

        List<Product> list2 = new ArrayList<>();
        list2.add(new Product("Baton", 2.5, 700));
        list2.add(new Product("Chipsy", 11, 900));
        list2.add(new Product("Pierniczki", 9, 750));

        List<Product> mergedLists = mergeLists(list1, list2);
        printProducts(mergedLists);

        //exercise 003
        List<Product> list3 = new ArrayList<>();
        list3.add(new Product("Mleko", 25, 1000));
        list3.add(new Product("Szynka", 11, 1200));
        list3.add(new Product("Kiełbasa", 7, 1500));
        printProducts(list3);
        returnNElement(1, list3);
    }

    private static List<Product> removeRandomProduct(List<Product> list){
        Random rand = new Random();
        for(int i = 0; i < list.size(); i++){
            int randomIndex = rand.nextInt(list.size());
            Product removedProduct = list.remove(randomIndex);
            System.out.println("\nUsunięto " + removedProduct.getName() + " z listy.");
        }
        return list;
    }
    private static void printProducts(List<Product> list){
        System.out.println("\nPozostałe produkty:");
        for (Product product : list) {
            System.out.println(product.getName() + " - " + product.getPrice() + " zł - " + product.getCalorificValue() + " kcal");
        }
    }

    private static int findMaxCalories(List<Product> list){
        int maxCallories = Integer.MIN_VALUE;
        for (Product product : list) {
            if (product.getCalorificValue() > maxCallories) {
                maxCallories = product.getCalorificValue();
            }
        }
        return maxCallories;
    }

    private static List<Product> removeMaxCallories(List<Product> list, int maxCallories) {
        List<Product> doUsuniecia = new ArrayList<>();
        for (Product produkt : list) {
            if (produkt.getCalorificValue() == maxCallories) {
                doUsuniecia.add(produkt);
            }
        }
        list.removeAll(doUsuniecia);
        System.out.println("\nUsunięto " + doUsuniecia.size() + " produkt(y) o największej kaloryczności.");
        return list;
    }

    private static List<Product> mergeLists(List<Product> list1, List<Product> list2) {
        List<Product> mergedList = new ArrayList<>();
        int maxSize = Math.max(list1.size(), list2.size());

        for (int i = 0; i < maxSize; i++) {
            if (i < list1.size()) {
                mergedList.add(list1.get(i));
            }
            if (i < list2.size()) {
                mergedList.add(list2.get(i));
            }
        }
        return mergedList;
    }

    private static Product returnNElement(int n, List<Product> list){
        Product nElement = null;
        for(int i = list.size(); i > 0; i--){
            if(i == list.size() - n - 1){
                nElement = list.get(i);
                System.out.println("\nZnaleziono n produkt = " + nElement.getName() + " - " + nElement.getPrice() + " zł - " + nElement.getCalorificValue() + " kcal");
                break;
            }
        }
        return nElement;
    }
}