package view;

import model.services.exceptions.NoRecException;
import model.services.exceptions.PetCreationException;

public interface View {
    void start() throws PetCreationException, NoRecException;
    void printAnswer(String answer);
}
