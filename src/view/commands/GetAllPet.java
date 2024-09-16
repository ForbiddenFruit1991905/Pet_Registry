package view.commands;

import model.services.exceptions.NoRecException;
import view.ConsoleUI;

public class GetAllPet extends Commands{

    public GetAllPet(ConsoleUI consoleUI) {
        super("вывести список животных, внесенных в реестр", consoleUI);
    }

    @Override
    public void execute() throws NoRecException {
        getConsoleUI().getAllPet();
    }
}
