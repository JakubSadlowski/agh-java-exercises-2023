package org.reader;

import java.time.Year;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PresidentFilter {
    private final List<President> list;

    public PresidentFilter(List<President> list) {
        this.list = list;
    }

     List<President> findPresidentsForParty(Party party) {
        List<President> result = list.stream().filter(p -> party.equals(p.getParty())).
                collect(Collectors.toList());
        return result;
    }

    public President findPresidentWithShortestCadency() {
        return list.stream()
                .min(Comparator.comparingInt(President::getCadency))
                .orElse(null);
    }

    public Optional<President> findPresidentWithinGivenCadencyYear(Year year){
        return list.stream().filter(p -> !year.isBefore(p.getStartYear()) && !year.isAfter(p.getEndYear())).findFirst();
    }
}
