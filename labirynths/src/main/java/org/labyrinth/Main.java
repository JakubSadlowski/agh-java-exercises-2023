package org.labyrinth;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        // Provide your own paths to the files
        File file1 = new File("C:\\Users\\jakub\\Programming\\Java Projects\\AGH-Java_Exercises-2023\\labirynths\\labyrinth1.txt");
        File file2 = new File("C:\\Users\\jakub\\Programming\\Java Projects\\AGH-Java_Exercises-2023\\labirynths\\labyrinth2.txt");
        File file3 = new File("C:\\Users\\jakub\\Programming\\Java Projects\\AGH-Java_Exercises-2023\\labirynths\\labyrinth3.txt");

        System.out.println("Labyrinth1 Brute Force: ");
        labyrinthBruteForce(file1);

        System.out.println("Labyrinth1 Dijkstra: ");
        labyrinthDijkstra(file1);

        System.out.println("Labyrinth2 Brute Force: ");
        labyrinthBruteForce(file2);

        System.out.println("Labyrinth2 Dijkstra: ");
        labyrinthDijkstra(file2);

        System.out.println("Labyrinth3 Brute Force: ");
        labyrinthBruteForce(file3);

        System.out.println("Labyrinth3 Dijkstra: ");
        labyrinthDijkstra(file3);
    }

    private static void labyrinthBruteForce(File file) {
        LabyrinthBruteForceSolution labyrinth = new LabyrinthBruteForceSolution(file);
        labyrinth.printLabyrinth();
        System.out.println("\n\n");
        int steps = 0;
        long startTime = System.nanoTime();
        steps = labyrinth.solveLabyrinth();
        long endTime = System.nanoTime();
        long elapsedTime = (endTime - startTime)/1000;
        System.out.println("\nBrute force solving time: " + elapsedTime + "ms");
        System.out.println("Brute force steps: " + steps + "\n");
    }

    private static void labyrinthDijkstra(File file) {
        LabyrinthDijkstraSolution labyrinth = new LabyrinthDijkstraSolution(file);
        labyrinth.printLabyrinth();
        System.out.println("\n\n");
        int steps = 0;
        long startTime = System.nanoTime();
        steps = labyrinth.solveLabyrinth();
        long endTime = System.nanoTime();
        long elapsedTime = (endTime - startTime)/1000;
        System.out.println("\nDijkstra solving time: " + elapsedTime + "ms");
        System.out.println("Dijkstra steps: " + steps + "\n");
    }

}