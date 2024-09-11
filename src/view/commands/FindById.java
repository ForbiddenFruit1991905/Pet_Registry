package view.commands;

import view.ConsoleUI;

public class FindById extends Commands{

    public FindById(ConsoleUI consoleUI) {
        super("найти запись о животном по Id", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().findById();
    }
}
