package org.labyrinth;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\jakub\\Programming\\Java Projects\\AGH-Java_Exercises-2023\\labirynths\\labyrinth1.txt");
        Labyrinth labyrinth1 = new Labyrinth();
        labyrinth1.createLabyrinth(file);
        labyrinth1.printLabyrinth();
    }
}