package org.labyrinth;

import java.io.File;
import java.util.Arrays;
import java.util.PriorityQueue;

public class LabyrinthDijkstraSolution {

    private static String[][] labyrinth;

    private final int numberOfRows;

    private final int numberOfColumns;

    private final String PATH = "p";

    private final String WALL = "#";

    public LabyrinthDijkstraSolution(File file){
        LabyrinthReader reader = new LabyrinthReader();
        labyrinth = reader.readFile(file);
        numberOfRows = reader.getRowsCounter();
        numberOfColumns = reader.getColumnsCounter();
    }

    static class Node implements Comparable<Node> {
        int row, col, distance;

        Node(int row, int col, int distance) {
            this.row = row;
            this.col = col;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.distance, other.distance);
        }
    }

    public int solveLabyrinth() {
        int startRow = 0;
        int startCol = 0;
        int endRow = numberOfRows - 1;
        int endCol = numberOfColumns - 1;
        int steps = 0;

        int[][] distances = new int[numberOfRows][numberOfColumns];
        for (int[] row : distances) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        distances[startRow][startCol] = 0;

        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new Node(startRow, startCol, 0));

        while (!priorityQueue.isEmpty()) {
            Node current = priorityQueue.poll();
            int row = current.row;
            int col = current.col;
            int distance = current.distance;

            if (row == endRow && col == endCol) {
                steps = reconstructPath(distances, endRow, endCol);
                break;
            }

            exploreNeighbor(priorityQueue, distances,row + 1, col, distance + 1);
            exploreNeighbor(priorityQueue, distances, row - 1, col, distance + 1);
            exploreNeighbor(priorityQueue, distances, row, col + 1, distance + 1);
            exploreNeighbor(priorityQueue, distances, row, col - 1, distance + 1);
        }

        printLabyrinth();
        return steps;
    }

    private void exploreNeighbor(PriorityQueue<Node> priorityQueue, int[][] distances, int newRow, int newCol, int newDistance) {
        if (newRow < 0 || newRow >= numberOfRows || newCol < 0 || newCol >= numberOfColumns
                || labyrinth[newRow][newCol].equals(WALL) || newDistance >= distances[newRow][newCol]) {
            return;
        }

        distances[newRow][newCol] = newDistance;
        priorityQueue.add(new Node(newRow, newCol, newDistance));
    }

    private int reconstructPath(int[][] distances, int endRow, int endCol) {
        int currentRow = endRow;
        int currentCol = endCol;
        int steps = 0;

        while (distances[currentRow][currentCol] != 0) {
            labyrinth[currentRow][currentCol] = PATH;
            steps++;
            int distance = distances[currentRow][currentCol];

            if (currentRow > 0 && distances[currentRow - 1][currentCol] == distance - 1) {
                currentRow--;
            } else if (currentRow < numberOfRows - 1 && distances[currentRow + 1][currentCol] == distance - 1) {
                currentRow++;
            } else if (currentCol > 0 && distances[currentRow][currentCol - 1] == distance - 1) {
                currentCol--;
            } else if (currentCol < numberOfColumns - 1 && distances[currentRow][currentCol + 1] == distance - 1) {
                currentCol++;
            }
        }
        return steps;
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
}

