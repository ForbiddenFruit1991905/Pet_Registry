package view;

import model.services.exceptions.PetCreationException;

public interface View {
    void start() throws PetCreationException;
    void printAnswer(String answer);
}
