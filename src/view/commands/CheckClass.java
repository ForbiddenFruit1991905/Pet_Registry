package view.commands;

import view.ConsoleUI;

public class CheckClass extends Commands{
    public CheckClass(ConsoleUI consoleUI) {
        super("определить животное по классу", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().checkClass();
    }

}
