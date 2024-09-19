package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Hamster extends Pet implements Petable {

    public Hamster(String name, PetType type, LocalDate birthday, LocalDate deathDate, ArrayList<String> commands) {
        super(name, type, birthday, deathDate, commands);
    }

    @Override
    public void play() {
        System.out.println("Хомяк прокрутился вокруг себя");
    }
}
