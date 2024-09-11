import model.Pet;
import model.services.IRepository;
import model.services.PetRepository;
import view.ConsoleUI;
import view.View;

import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        View view = new ConsoleUI();
        view.start();



//        PetRepository repository = new PetRepository();
//        Pet newPet = new Pet("Мурзик", LocalDate.of(2020, 5, 15), null, new ArrayList<>());
//        repository.addPet(newPet); // Добавление объекта newPet в репозиторий
//        PetRepository repository = new PetRepository();
//        Pet newPet = new Pet("Мурзик", LocalDate.of(2020, 5, 15), null, new ArrayList<>());
//        IRepository petAsIRepository = new PetAdapter(newPet); // Предположим, что используется адаптер PetAdapter для преобразования Pet в IRepository
//        repository.addPet((Pet) petAsIRepository); // Добавление объекта, реализующего интерфейс IRepository, в репозиторий


    }
}