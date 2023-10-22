package org.reader;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PartyTest {
    @Test
    public void testParseForName(){
        Assertions.assertEquals(Party.DEMOCRATIC, Party.forName("Democratic"));
    }
}