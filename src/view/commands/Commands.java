package view.commands;

import model.services.PetCreationException;
import view.ConsoleUI;

public abstract class Commands {
    private String option;
    private ConsoleUI consoleUI;

    public Commands(String option, ConsoleUI consoleUI) {
        this.option = option;
        this.consoleUI = consoleUI;
    }

    public String getOption() {
        return option;
    }

    ConsoleUI getConsoleUI() {
        return consoleUI;
    }

    public abstract void execute() throws PetCreationException;
}
