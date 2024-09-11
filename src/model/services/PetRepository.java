package model.services;

import model.Pet;
import model.comparator.ComparatorByDateBirth;
import model.comparator.ComparatorByName;
import model.iterator.PetIterator;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class PetRepository<T extends IRepository<T>> {
    private List<T> pets;
    private PetBuilder petBuilder;

    public PetRepository() {
        this.pets = new ArrayList<>();
        this.petBuilder = new PetBuilder();
    }

    public List<T> getAllPet() {
        return pets;
    }

    // Нахождение записи по ID
    public T findById(int idPet) {
        for (T pet : pets) {
            if (Objects.equals(pet.getId(), idPet)) {
                return pet;
            }
        }
        return null;
    }


//    public void addPet(Pet pet) {
//        pets.add((T) pet);
//    }

    // Добавление зверюшки
    public T addNewPet(String name, LocalDate birthday, LocalDate deathDate, ArrayList commands) {
        Pet pet = petBuilder.build(name, birthday, deathDate, commands);
        pets.add((T)pet);
        return (T) pet;
    }

    // Удалить запись по ID
    public T deleteById(int idPet) {
        for (T pet : pets) {
            if (Objects.equals(pet.getId(), idPet)) {
                return pets.remove(idPet - 1);
            }
        }
        return null;
    }
    
    // Список всех записей
    public String getPetList() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список животных:\n");
        for (T pet : pets) {
            stringBuilder.append(pet);
            stringBuilder.append("n");
        }
        return stringBuilder.toString();
    }
     //TODO нет логики метода
    /*
    public String getListOfCommands() {

    }
     */
    
    public Iterator<T> iterator() {
        return new PetIterator<>(pets);
    }

    public void sortByName(){
        pets.sort(new ComparatorByName<>());
    }

    public void sortByAge(){
        pets.sort(new ComparatorByDateBirth<>());
    }
}




