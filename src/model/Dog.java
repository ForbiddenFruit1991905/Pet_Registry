package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Dog extends Pet implements Petable {
//    public Dog(String name, LocalDate birthday, LocalDate deathDate, ArrayList<Pet> commands) {
//        super(name, birthday, deathDate, commands);
//    }

    public Dog(String name) {
        super(name);
    }

    @Override
    public void play() {
        System.out.println("Собака падает лапу");
    }
}
