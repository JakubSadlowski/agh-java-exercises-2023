package org.labyrinth;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class LabyrinthReader {

    private int rowsCounter = 0;

    private int columnsCounter = 0;

    public String[][] readFile(File file) {
        int numberOfRows = getNumberOfRows(file);
        int numberOfColumns = getNumberOfColumns(file);
        String[][] labyrinth = new String[numberOfRows][numberOfColumns];
        int counter = 0;
        try (BufferedReader in = new BufferedReader(
                new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8))) {
            String line;
            for (int i = 0; i < numberOfRows; i++) {
                line = in.readLine();
                String[] characters = line.split(";");
                for (int j = 0; j < numberOfColumns; j++){
                    labyrinth[i][j] = characters[j];
                }
            }

        } catch (IOException e) {
            throw new RuntimeException("Failed to read file " + file.getAbsolutePath(), e);
        }
        return labyrinth;
    }

    public int getRowsCounter() {
        return rowsCounter;
    }

    public int getColumnsCounter() {
        return columnsCounter;
    }

    private int getNumberOfRows(File file) {
        try (BufferedReader in = new BufferedReader(
                new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8))) {
            while (in.readLine() != null) {
                rowsCounter++;
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return rowsCounter;
    }

    private int getNumberOfColumns(File file) {
        try (BufferedReader in = new BufferedReader(
                new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8))) {

            String firstLine = in.readLine();
            String[] columns = firstLine.split(";");
            columnsCounter = columns.length;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return columnsCounter;
    }
}