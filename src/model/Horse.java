package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Horse extends Pet implements Packable, Petable {

    public Horse(String name, PetType type, LocalDate birthday, LocalDate deathDate, ArrayList<String> commands) {
        super(name, type, birthday, deathDate, commands);
    }

    @Override
    public void carryLoad() {
        System.out.println("Лошадка носит груз");
    }

    @Override
    public void play() {
        System.out.println("Обучаема командам таким как - скакать голопом");
    }
}
