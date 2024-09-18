package view.commands;

import view.ConsoleUI;

public class LearnNewCommand extends Commands{

    public LearnNewCommand(ConsoleUI consoleUI) {
        super("выучить новую команду", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().learnNewCommand();
    }

}
