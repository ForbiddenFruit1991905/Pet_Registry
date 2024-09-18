package view.commands;

import view.ConsoleUI;

public class GetAllPet extends Commands{

    public GetAllPet(ConsoleUI consoleUI) {
        super("вывести список животных, внесенных в реестр", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().getAllPet();
    }
}
