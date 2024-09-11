package view.commands;

import view.ConsoleUI;

public class GetListOfCommands extends Commands{

    public GetListOfCommands(ConsoleUI consoleUI) {
        super("вывести список команд по имени животного", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().getListOfCommands();
    }
}
