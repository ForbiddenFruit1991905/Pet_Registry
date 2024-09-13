package model.services;

import model.Pet;

import java.util.Iterator;
import java.util.List;

public interface IRepository<T> extends Comparable{
    List<T> getAll();
    int getId();
    String getName();
    int getAge();
    List<T> getAllPet();
    Pet findById(int idPet);

    String getCommands();
    void addCommand(T command);
    String getInfo();
    T getById(int id);

    T addNewPet(T pet);
//    void add(T pet);
    T deleteById(int idPet);
    String getPetList();

    Iterator<T> iterator();
}
