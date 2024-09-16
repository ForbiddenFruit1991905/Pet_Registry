package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Donkey extends Pet implements Packable {

    public Donkey(String name, LocalDate birthday, LocalDate deathDate, ArrayList<String> commands) {
        super(name, birthday, deathDate, commands);
    }

    @Override
    public void carryLoad() {
        System.out.println("Ослик носит груз");
    }
}
