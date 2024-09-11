package model;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Pet {
    protected static int id;
    public String name;
    public LocalDate birthday;
    private LocalDate deathDate;
    public ArrayList<Pet> commands;

    public Pet(String name, LocalDate birthday, LocalDate deathDate, ArrayList<Pet> commands) {
        this.name = name;
        this.birthday = birthday;
        this.deathDate = deathDate;
        this.commands = commands;
    }
    //TODO убрать
    public Pet(String name) {
    }

    public Pet() {

    }

    public LocalDate getDeathDate() {
        return deathDate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBirthday() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return formatter.format(birthday);
    }

    public ArrayList<Pet> getCommands() {
        return commands;
    }
    //TODO 1
    // что-то на непонятном
    public void addCommand(Pet command){
        commands.add(command);
    }

//    public boolean getCommand(Pet command) {
//        if (!commands.contains(command)){
//            commands.add(command);
//            return true;
//        }
//        return false;
//    }

    public String getInfo() {
        StringBuilder list = new StringBuilder();
        list.append("Обучен(а) следующим командам: ");
        if (!commands.isEmpty()) {
            list.append(commands.get(0).getCommands());
            for (int i = 1; i < commands.size(); i++) {
                list.append(", ");
                list.append(commands.get(i).getCommands());
            }
        } else {
            list.append("нет");
        }
        return list.toString();
    }


    @Override
    public String toString() {
        return String.format("ID: "+ getId(), "name: " + getName(), "birthday:" + getBirthday() + getInfo());
    }

    public int getPetAge(){
        if (deathDate == null){
            return getPeriod(birthday, LocalDate.now());
        }
        return getPeriod(birthday, deathDate);
    }

    private int getPeriod(LocalDate birthday, LocalDate deathDate){
        Period diff = Period.between(birthday, deathDate);
        return diff.getYears();
    }

    public int getAge() {
        return getPetAge();
    }


    public Pet addNewPet(Pet pet) {
        return pet;
    }

    public Pet findById(int idPet) {
        return null;
    }

    public Pet deleteById(int count_id) {
        return null;
    }

}
