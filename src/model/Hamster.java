package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Hamster extends Pet implements Petable {
    public Hamster(String name, LocalDate birthday, LocalDate deathDate, ArrayList<Pet> commands) {
        super(name, birthday, deathDate, commands);
    }

    public Hamster(String name) {
        super();
    }

    @Override
    public void play() {
        System.out.println("Хомяк прокрутился вокруг себя");
    }
}
