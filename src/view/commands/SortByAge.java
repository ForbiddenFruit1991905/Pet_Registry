package view.commands;

import view.ConsoleUI;

public class SortByAge extends Commands{

    public SortByAge(ConsoleUI consoleUI) {
        super("сортировка по возрасту", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().sortByAge();
    }
}
