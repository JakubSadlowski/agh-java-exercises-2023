package org.reader;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PresidentFilterTest {
    private static final String FILE_PATH = "./presidents.txt";
    private static List<President> presidents;
    @BeforeAll
    static void setup(){
        PresidentsFileReader fileReader = new PresidentsFileReader();
        presidents = fileReader.readFile(new File(FILE_PATH));
    }

    @Test
    void testNumberOfDemocraticPresidents(){
        // given
        PresidentFilter filter = new PresidentFilter(presidents);

        // when
        List<President> result = filter.findPresidentsForParty(Party.DEMOCRATIC);

        // then
        Assertions.assertEquals(8, result.size());
    }
    @Test
    void testNumberOfFederalistPresidents(){
        // given
        PresidentFilter filter = new PresidentFilter(presidents);

        // when
        List<President> result = filter.findPresidentsForParty(Party.FEDERALIST);

        // then
        Assertions.assertEquals(1, result.size());
    }

}