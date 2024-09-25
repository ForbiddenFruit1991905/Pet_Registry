package model.services;

import model.Pet;
import model.PetType;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public interface IRepository<T> extends Comparable{
    List<T> getAll();
    int getId();
    String getName();
    int getAge();
    List<T> getAllPet();
    Pet findById(int idPet);
    ArrayList<String> getCommands();
    boolean getCommand(String command);
    PetType checkClass();
    String learnNewCommand(String newCommand);
    String getInfo();
    T getById(int id);
    T addNewPet(T pet);
    T deleteById(int idPet);
    String getPetList();
    Iterator<T> iterator();
}
