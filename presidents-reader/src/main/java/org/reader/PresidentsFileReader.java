package org.reader;

import org.apache.commons.lang3.tuple.Pair;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.Year;
import java.util.*;

public class PresidentsFileReader {
    /**
     * Reading file using array to store lines of text
     */
    static List<President> readFile(File file) {
        int numberOfRows = getNumberOfRows(file);
        President[] presidents = new President[numberOfRows];
        int counter = 0;
        try (BufferedReader in = new BufferedReader(
                new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8))) {
            String line;
            while ((line = in.readLine()) != null) {
                President president = parseLine(line);
                System.out.println(president);
                presidents[counter++] = president;
            }

        } catch (IOException e) {
            throw new RuntimeException("Failed to read file " + file.getAbsolutePath(), e);
        }
        return Collections.unmodifiableList(Arrays.asList(presidents));
    }
    private static President parseLine(String line) {
        String[] parts = line.split(";");
        Pair<Year, Year> yearFromTo = parseYearFromTo(parts[2]);
        return President.builder().firstName(parts[0]).name(parts[1]).startYear(yearFromTo.getLeft()).
                endYear(yearFromTo.getRight()).party(Party.forName(parts[3])).build();
    }

    private static Pair<Year, Year> parseYearFromTo(String yearFromToString) {
        String[] elements = yearFromToString.split("-");
        Year yearFrom = Year.parse(elements[0]);
        Year yearTo = Year.parse(elements[1]);
        Year minYearFrom = yearFrom.isBefore(yearTo) ? yearFrom : yearTo;
        Year maxYearFrom = yearFrom.isBefore(yearTo) ? yearTo : yearFrom;
        return Pair.of(minYearFrom, maxYearFrom);
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
}
