package model.services;

import model.*;
import model.comparator.ComparatorByDateBirth;
import model.comparator.ComparatorByName;
import model.iterator.PetIterator;
import java.time.LocalDate;
import java.util.*;

public class PetRepository<T extends IRepository<T>> implements Iterable<T>{
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
    public T findById(int count_id) {
        for (T pet : pets) {
            if (Objects.equals(pet.getId(), count_id)) {
                return pet;
            }
        }
        return null;
    }

    // Добавление зверюшки
    public T addNewPet(String name, LocalDate birthday, LocalDate deathDate, ArrayList<String> commands) {
        Pet pet = petBuilder.build(name, birthday, deathDate, commands);
        pets.add((T)pet);
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

    public void checkClass() {

        // Вар.1
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Введите имя животного: ");
//        String name = scanner.nextLine();
//
//        for (T pet : pets) {
//            if (pet.getName().equalsIgnoreCase(name)) {
//                if (pet instanceof Cat) {
//                    System.out.println("Животное " + name + " принадлежит к классу Кот");
//                } else if (pet instanceof Dog) {
//                    System.out.println("Животное " + name + " принадлежит к классу Собака");
//                } else if (pet instanceof Camel) {
//                    System.out.println("Животное " + name + " принадлежит к классу Верблюд");
//                } else {
//                    System.out.println("Не удалось определить класс животного " + name);
//                }
//                return;
//            }
//        }
//
//        System.out.println("Животное с указанным именем не найдено.");

        //TODO доработать  Вар.2
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите вид животного: 1 - кот, 2 - собака, 3 - хомяк, 4 - лошадь, 5 - верблюд, 6 - ослик");
        int choice = scanner.nextInt();
        System.out.println("Список животных по типам: ");
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
            }
            
            System.out.println(pet.getName() + " " /*+ pet.getClass()*/ + choice);


            // Вар.3
//        for (T pet : pets) {
//            if (pet instanceof Cat) {
//                System.out.println("Кошка: " + pet.getName());
//            } else if (pet instanceof Dog) {
//                System.out.println("Собака: " + pet.getName());
//            } else if (pet instanceof Hamster) {
//                System.out.println("Хомяк: " + pet.getName());
//            } else if (pet instanceof Camel) {
//                System.out.println("Верблюд: " + pet.getName());
//            } else if (pet instanceof Horse) {
//                System.out.println("Лошадь: " + pet.getName());
//            } else if (pet instanceof Donkey) {
//                System.out.println("Ослик: " + pet.getName());
//            }
//            }
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


    //TODO
    public void LearnNewCommand() {
//        pets.addCommand();
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




