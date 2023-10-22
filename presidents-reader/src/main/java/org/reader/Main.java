package org.reader;

import java.io.File;
import java.time.Year;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            throw new RuntimeException("Please provide the file path as the only argument.");
        }

        File file = new File(args[0]);
        System.out.println("Reading into list info about presidents of USA from file: " + file.getAbsolutePath() + "\n");
        PresidentsFileReader fileReader = new PresidentsFileReader();
        List<President> presidents = fileReader.readFile(file);

        System.out.println("\n\nAnswer some questions about presidents:");
        PresidentFilter filter = new PresidentFilter(presidents);
        System.out.println("Number of Democratic presidents = " + filter.findPresidentsForParty(Party.DEMOCRATIC).size());
        System.out.println("President with shortest cadency was: " + filter.findPresidentWithShortestCadency());
        System.out.println("President with cadency in year 1866 was: " +
                filter.findPresidentWithinGivenCadencyYear(Year.of(1869)));
    }
}