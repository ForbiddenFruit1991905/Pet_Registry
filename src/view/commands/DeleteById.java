package view.commands;

import view.ConsoleUI;

public class DeleteById extends Commands{
    public DeleteById(ConsoleUI consoleUI) {
        super("удалить запись о дивотном из реестра по Id", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().deleteById();
    }
}
