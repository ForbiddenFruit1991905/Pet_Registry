package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Camel extends Pet implements Packable {

    public Camel(String name, PetType type, LocalDate birthday, LocalDate deathDate, ArrayList<String> commands) {
        super(name, type, birthday, deathDate, commands);
    }

    @Override
    public void carryLoad() {
        System.out.println("Верблюд носит груз");
    }
}

