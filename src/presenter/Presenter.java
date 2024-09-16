package presenter;

import model.Pet;
import model.services.exceptions.PetCreationException;
import model.services.PetRepository;
import view.View;

import java.time.LocalDate;
import java.util.ArrayList;

public class Presenter {
    private PetRepository petRepository;
    private View view;

    public Presenter(View view) {
        this.view = view;
        petRepository = new PetRepository();
    }

    //TODO не уверена что правильно будет работать из-за return(name)
    //    Добавить новую запись
    public String addNewPet(String name, LocalDate birthday, LocalDate deathDate, ArrayList commands) throws PetCreationException {
        petRepository.addNewPet(name, birthday, deathDate, commands);
        return name;
    }

    //    Поиск записи по ID
    public Pet findById(int count_id) {
        return (Pet) petRepository.findById(count_id);
    }

    //    Проверка класса
    public void checkClass() {
        petRepository.checkClass();
    }

    //    Удаление записи
    public void deleteById(int count_id) {
        petRepository.deleteById(count_id);
    }

    //    Список всех записей животных в реестре
    public boolean getPetList() {
        String answer = petRepository.getPetList();
        view.printAnswer(answer);
        return false;
    }

    //    Сортировка по возрасту
    public void getComparatorByDateBirth() {
        petRepository.sortByAge();
    }

    //    Сортировка по имени
    public void getComparatorByName() {
        petRepository.sortByName();
    }
}
