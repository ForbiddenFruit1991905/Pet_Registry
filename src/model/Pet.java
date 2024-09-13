package model;

import model.services.IRepository;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Pet implements IRepository {
    private int id;
    private String name;
    private LocalDate birthday;
    private LocalDate deathDate;
    private ArrayList<String> commands;

    public Pet(int id, String name, LocalDate birthday, LocalDate deathDate, ArrayList<String> commands) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.deathDate = deathDate;
        this.commands = commands;
    }
    //TODO убрать?
    public Pet(String name) {

    }

    public LocalDate getDeathDate() {
        return deathDate;
    }

    @Override
    public List getAll() {
        return List.of();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBirthday() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return formatter.format(birthday);
    }

    public String getCommands() {
        return commands.toString();
    }


    //TODO пустой метод
    @Override
    public void addCommand(Object command) {

    }

    //TODO 1
    // что-то на непонятном
    public void addCommand(String command){
        commands.add(command);
    }

//    public String getAnimalCommands() {
//        return commands.toString();
//    }
//
//    public void addCommand(String command){
//        commands.add(command);
//
//    }

//    public boolean getCommand(Pet command) {
//        if (!commands.contains(command)){
//            commands.add(command);
//            return true;
//        }
//        return false;
//    }

//TODO доработать
    public String getInfo() {
        StringBuilder list = new StringBuilder();
        list.append("Обучен(а) следующим командам: ");
        if (!commands.isEmpty()) {
            list.append(commands.get(0)/*.getCommands()*/);
            for (int i = 1; i < commands.size(); i++) {
                list.append(", ");
                list.append(commands.get(i)/*.getCommands()*/);
            }
        } else {
            list.append("нет");
        }
        return list.toString();
    }

    @Override
    public Object getById(int id) {
        return null;
    }

    @Override
    public Object addNewPet(Object pet) {
        return null;
    }

    @Override
    public Object deleteById(int idPet) {
        return null;
    }

    @Override
    public String getPetList() {
        return List.of().toString();
    }

    @Override
    public Iterator iterator() {
        return null;
    }


    @Override
    public String toString() {
        return String.format("ID: " + getId() + "\n" + "name: " + getName() + "\n" + "birthday:" + getBirthday() /*+ getInfo()*/);
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

    @Override
    public List getAllPet() {
        return List.of();
    }

    @Override
    public Pet findById(int idPet) {
        return null;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

}
