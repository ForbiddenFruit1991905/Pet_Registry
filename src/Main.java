
import model.services.exceptions.PetCreationException;
import view.ConsoleUI;
import view.View;

public class Main {
    public static void main(String[] args) throws PetCreationException {
        View view = new ConsoleUI();
        view.start();
    }
}