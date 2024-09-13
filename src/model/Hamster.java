package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Hamster extends Pet implements Petable {

    public Hamster(String name) {
        super(name);
    }

    @Override
    public void play() {
        System.out.println("Хомяк прокрутился вокруг себя");
    }
}
