package model.services;

import model.*;
import model.comparator.ComparatorByDateBirth;
import model.comparator.ComparatorByName;
import model.iterator.PetIterator;
import model.services.exceptions.PetCreationException;

import java.time.LocalDate;
import java.util.*;

public class PetRepository<T extends IRepository<T>> implements Iterable<T> {
    private List<T> pets;
    private PetBuilder petBuilder;

    public PetRepository() {
        this.pets = new ArrayList<>();
        this.petBuilder = new PetBuilder();
    }

//    public List<T> getAllPet() {
//        return pets;
//    }

    // Нахождение записи по ID
    public T findById(int count_id) {
        for (T pet : pets) {
            if (Objects.equals(pet.getId(), count_id)) {
                return pet;
            }
        }
        return null;
    }

    // Добавление зверюшки
    public T addNewPet(String name, LocalDate birthday, LocalDate deathDate, ArrayList<String> commands) throws PetCreationException {
        if (name == null || birthday == null || commands.isEmpty()) {
            throw new PetCreationException("Недостаточно информации для создания нового питомца");
        }
        Pet pet = petBuilder.build(name, birthday, deathDate, commands);
        pets.add((T) pet);
        return (T) pet;
    }

    // Удалить запись по ID
    public T deleteById(int count_id) {
        for (T pet : pets) {
            if (Objects.equals(pet.getId(), count_id)) {
                return pets.remove(count_id - 1);
            }
        }
        return null;
    }

    // TODO Проверка класса - некорректно работает
    public void checkClass() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите вид животного: 1 - кот, 2 - собака, 3 - хомяк, 4 - лошадь, 5 - верблюд, 6 - ослик");
        int choice = scanner.nextInt();
        System.out.println("Список животных выбранного типа:");
        for (T pet : pets) {
            if (choice == 1 && pet instanceof Cat) {
                System.out.println("Кошка: " + pet.getName());
            } else if (choice == 2 && pet instanceof Dog) {
                System.out.println("Собака: " + pet.getName());
            } else if (choice == 3 && pet instanceof Hamster) {
                System.out.println("Хомяк: " + pet.getName());
            } else if (choice == 4 && pet instanceof Camel) {
                System.out.println("Верблюд: " + pet.getName());
            } else if (choice == 5 && pet instanceof Horse) {
                System.out.println("Лошадь: " + pet.getName());
            } else if (choice == 6 && pet instanceof Donkey) {
                System.out.println("Ослик: " + pet.getName());
            }
            System.out.println(pet.getName());
        }
   }

    // Список всех записей
    public String getPetList() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список животных:\n");
        for (T pet : pets) {
            stringBuilder.append(pet);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

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




