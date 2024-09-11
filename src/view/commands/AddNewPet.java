package view.commands;

import view.ConsoleUI;

public class AddNewPet extends Commands{
    public AddNewPet(ConsoleUI consoleUI) {
        super("добавить новую запись о животном в реестр", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().addNewPet();
    }
}
