package presenter;

import model.Pet;
import model.PetType;
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

    //    Добавить новое животное в реестр
    public String addNewPet(String name, PetType type, LocalDate birthday, LocalDate deathDate, ArrayList commands) throws PetCreationException {
        petRepository.addNewPet(name, type, birthday, deathDate, commands);
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

    // Выучить новую команду
    public void learnNewCommand(String newCommand) {
        petRepository.learnNewCommand(newCommand);
    }

    //    Удаление записи
    public void deleteById(int count_id) {
        petRepository.deleteById(count_id);
    }

    //    Список всех записей животных в реестре
    public String getPetList(){
        String answer = petRepository.getPetList();
        view.printAnswer(answer);
        return "";
    }

    //    Сортировка по возрасту
    public void getComparatorByDateBirth() {
        petRepository.sortByAge();
    }

    //    Сортировка по имени
    public void getComparatorByName() {
        petRepository.sortByName();
    }

    public String getCommands() {
        return petRepository.getCommands();
    }
}
