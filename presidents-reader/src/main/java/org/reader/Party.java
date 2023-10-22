package org.reader;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public enum Party {
    UNAFFILIATED("Unaffiliated"), FEDERALIST("Federalist"), DEMOCRATIC_REPUBLICAN("Democratic-Republican"),
    DEMOCRATIC("Democratic"), WHIG("Whig"), REPUBLICAN("Republican");
    private String description;
    private static Map<String, Party> lookUp = new HashMap<>();
    static {
        for(Party party: Party.values()){
            lookUp.put(party.getDescription().toUpperCase(), party);
        }
    }
    Party(String name){
        this.description = name;
    }

    public String getDescription() {
        return description;
    }

    static Party forName(String name){
       return Objects.requireNonNull(lookUp.get(name.toUpperCase()), "Unrecognized enum value " + name);
    }
}