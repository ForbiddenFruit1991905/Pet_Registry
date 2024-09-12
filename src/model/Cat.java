package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Cat extends Pet implements Petable {
//    public Cat(String name, LocalDate birthday, LocalDate deathDate, ArrayList<Pet> commands) {
//        super(name);
//    }

    public Cat(String name) {
        super(name);
    }

    @Override
    public void play() {
            System.out.println("Кошка играет с клубочком ниток");
    }
}
