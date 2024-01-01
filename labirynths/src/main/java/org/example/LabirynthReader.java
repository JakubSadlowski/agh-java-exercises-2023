package org.example;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class LabirynthReader {
    static String[][] readFile(File file) {
        int numberOfRows = getNumberOfRows(file);
        int numberOfColumns = getNumberOfColumns(file);
        String[][] labirynth = new String[numberOfRows][numberOfColumns];
        int counter = 0;
        try (BufferedReader in = new BufferedReader(
                new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8))) {
            String line;
            for(int i = 0; i < numberOfRows; i++) {
                line = in.readLine();
                String[] characters = line.split(";");
                for(int j = 0; j < numberOfColumns; j++){
                    labirynth[i][j] = characters[j];
                }
            }

        } catch (IOException e) {
            throw new RuntimeException("Failed to read file " + file.getAbsolutePath(), e);
        }
        return null;
    }

    private static int getNumberOfRows(File file) {
        int rowsCounter = 0;
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

    private static int getNumberOfColumns(File file) {
        int columnsCounter = 0;
        try (BufferedReader in = new BufferedReader(
                new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8))) {

            String firstLine = in.readLine();
            String[] columns = firstLine.split("\t");
            columnsCounter = columns.length;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return columnsCounter;
    }
}
