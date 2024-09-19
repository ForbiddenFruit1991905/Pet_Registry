package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Cat extends Pet implements Petable {

    public Cat(String name, PetType type, LocalDate birthday, LocalDate deathDate, ArrayList<String> commands) {
        super(name, type, birthday, deathDate, commands);
    }

    @Override
    public void play() {
            System.out.println("Кошка играет с клубочком ниток");
    }
}
