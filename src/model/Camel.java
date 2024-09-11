package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Camel extends Pet implements Packable {
    public Camel(String name, LocalDate birthday, LocalDate deathDate, ArrayList<Pet> commands) {
        super(name, birthday, deathDate, commands);
    }

    public Camel(String name) {
        super(name);
    }

    @Override
    public void carryLoad() {
        System.out.println("Верблюд носит груз");
    }
}

