package org.reader;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.Year;

@Builder
@Getter
@ToString
public class President {
    private final String name;
    private final String firstName;
    private final Year startYear;
    private final Year endYear;
    private final Party party;

    public int getCadency() {
        return endYear.getValue() - startYear.getValue();
    }
}
