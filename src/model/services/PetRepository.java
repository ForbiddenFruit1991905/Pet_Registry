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
    public T addNewPet(String name, PetType type, LocalDate birthday, LocalDate deathDate, ArrayList<String> commands) throws PetCreationException {
        if (name == null || birthday == null || commands.isEmpty()) {
            throw new PetCreationException("Недостаточно информации для создания нового питомца");
        }
        Pet pet = petBuilder.build(name, type, birthday, deathDate, commands);
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
            switch (choice) {
                case 1:
                    if (pet instanceof Cat) {
                        System.out.println("Кошка: " + pet.getName());
                    }
                    break;
                case 2:
                    if (pet instanceof Dog) {
                        System.out.println("Собака: " + pet.getName());
                    }
                    break;
                case 3:
                    if (pet instanceof Hamster) {
                        System.out.println("Хомяк: " + pet.getName());
                    }
                    break;
                case 4:
                    if (pet instanceof Camel) {
                        System.out.println("Верблюд: " + pet.getName());
                    }
                    break;
                case 5:
                    if (pet instanceof Horse) {
                        System.out.println("Лошадь: " + pet.getName());
                    }
                    break;
                case 6:
                    if (pet instanceof Donkey) {
                        System.out.println("Ослик: " + pet.getName());
                    }
                    break;
                default:
                    System.out.println("Некорректный выбор.");
                    break;
            }
            System.out.println("petID: " + pet.getId() + " " + "Имя: " + pet.getName());
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

    // Добавить новую команду, выполняемую питомцем
    public void learnNewCommand(int petId, String newCommand) {
        Pet pet = (Pet) findById(petId);
        ArrayList allCommands = new ArrayList<>();
        if (pet != null) {
            allCommands.add(pet.getCommand(newCommand));
            System.out.println("Команда '" + newCommand + "' успешно добавлена для ID" + petId);
        } else {
            System.out.println("Питомец с таким ID не найден.");
        }
    }

    public String getCommands() {
        for (T pet : pets) {
            pet.getCommands();
        }
        return "";
    }

}




