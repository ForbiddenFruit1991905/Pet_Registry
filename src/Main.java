
import model.services.exceptions.NoRecException;
import model.services.exceptions.PetCreationException;
import view.ConsoleUI;
import view.View;

public class Main {
    public static void main(String[] args) throws PetCreationException, NoRecException {
        View view = new ConsoleUI();
        view.start();
    }
}