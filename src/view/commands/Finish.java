package view.commands;

import view.ConsoleUI;

public class Finish extends Commands{
    public Finish(ConsoleUI consoleUI)  {
        super("выход из приложения", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().finish();
    }
}
