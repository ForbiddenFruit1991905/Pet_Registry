package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Horse extends Pet implements Packable, Petable {
    public Horse(String name, LocalDate birthday, LocalDate deathDate, ArrayList<Pet> commands) {
        super(name, birthday, deathDate, commands);
    }

    public Horse(String name) {
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
