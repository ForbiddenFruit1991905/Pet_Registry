package model.services;

import model.Pet;
import model.PetType;

import java.time.LocalDate;
import java.util.ArrayList;

public class PetBuilder {
//    private abstract Pet buildNewPet(PetType type);
//    public Pet petBuilder (PetType type, String name, LocalDate date) {
    
    private int count_id = 1;
    public Pet build(String name, PetType type, LocalDate birthday, LocalDate deathDate, ArrayList<String> commands) {
        return new Pet(count_id++, name, type, birthday, deathDate, commands);
    }
}

/*

protected abstract Pet createNewPet(PetType type);

    public Pet createPet(PetType type, String name, LocalDate date) {

        Pet pet = createNewPet(type);
        pet.setName(name);
        pet.setBirthday(date);
        return pet;
    }

 */

