package view;

import model.services.PetCreationException;

public interface View {
    void start() throws PetCreationException;
    void printAnswer(String answer);
}
