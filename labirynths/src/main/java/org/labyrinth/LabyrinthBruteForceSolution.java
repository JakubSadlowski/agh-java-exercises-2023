package org.labyrinth;

import java.util.Random;
import java.io.File;

public class LabyrinthBruteForceSolution {

    private static String[][] labyrinth;

    private final int numberOfRows;

    private final int numberOfColumns;

    private final String PATH = "p";

    private final String WALL = "#";

    private final String EMPTY = " ";

    //private int endPositionX = numberOfRows - 1;

    //private int endPositionY = numberOfColumns - 1;

    private int currentPositionX = 0;

    private int currentPositionY = 0;

    public LabyrinthBruteForceSolution(File file){
        labyrinth = LabyrinthReader.readFile(file);
        numberOfRows = LabyrinthReader.rowsCounter;
        numberOfColumns = LabyrinthReader.columnsCounter;
    }

    public void printLabyrinth(){
        if (numberOfRows > 0) {
            for (int i = 0; i < numberOfRows; i++) {
                for (int j = 0; j < numberOfColumns; j++) {
                    System.out.print(labyrinth[i][j]);
                    if (j == numberOfColumns - 1)
                        System.out.print("\n");
                }
            }
        }
    }

    private void moveRight(){
        if (currentPositionY + 1 < numberOfColumns &&
                !(labyrinth[currentPositionX][currentPositionY + 1]).equals(WALL)){

            labyrinth[currentPositionX][currentPositionY + 1] = PATH;
            currentPositionY++;
        }
    }

    private void moveLeft(){
        if (currentPositionY - 1 >= 0 && !(labyrinth[currentPositionX][currentPositionY - 1]).equals(WALL)){

            labyrinth[currentPositionX][currentPositionY - 1] = PATH;
            currentPositionY--;
        }
    }

    private void moveUp(){
        if (currentPositionX - 1 >= 0 && !(labyrinth[currentPositionX - 1][currentPositionY]).equals(WALL)){

            labyrinth[currentPositionX - 1][currentPositionY] = PATH;
            currentPositionX--;
        }
    }

    private void moveDown(){
        if (currentPositionX + 1 < numberOfRows &&
                !(labyrinth[currentPositionX + 1][currentPositionY]).equals(WALL)){

            labyrinth[currentPositionX + 1][currentPositionY] = PATH;
            currentPositionX++;
        }
    }

    public void solveLabyrinth(){
        while (!labyrinth[numberOfRows - 1][numberOfColumns - 1].equals(PATH)){
            Random random = new Random();
            int direction = random.nextInt(4);
            switch(direction){
                case 0:
                    moveRight();
                    break;
                case 1:
                    moveDown();
                    break;
                case 2:
                    moveLeft();
                    break;
                case 3:
                    moveUp();
                    break;
            }
        }
        printLabyrinth();
    }
}
