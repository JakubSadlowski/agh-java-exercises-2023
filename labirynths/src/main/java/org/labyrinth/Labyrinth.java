package org.labyrinth;

import java.io.File;

public class Labyrinth {

    private String[][] labyrinth;

    private final int numberOfRows = LabyrinthReader.rowsCounter;

    private final int numberOfColumns = LabyrinthReader.columnsCounter;

    public void createLabyrinth(File file){
        labyrinth = LabyrinthReader.readFile(file);
    }

    public void printLabyrinth(){
        if(numberOfRows > 0) {
            for (int i = 0; i < numberOfRows; i++) {
                for (int j = 0; j < numberOfColumns; j++) {
                    System.out.print(labyrinth[i][j]);
                    if (j == numberOfColumns - 1)
                        System.out.print("\n");
                }
            }
        }
    }
}
