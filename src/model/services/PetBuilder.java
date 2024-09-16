package model.services;

import model.Pet;
import java.time.LocalDate;
import java.util.ArrayList;

public class PetBuilder {
    private int count_id = 1;
    public Pet build(String name, LocalDate birthday, LocalDate deathDate, ArrayList<String> commands) {
        return new Pet(count_id++, name, birthday, deathDate, commands);
    }
}

