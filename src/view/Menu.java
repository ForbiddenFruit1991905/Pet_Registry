package view;

import model.services.PetCreationException;
import view.commands.*;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<Commands> commandsList;

    public Menu(ConsoleUI consoleUI) {
        commandsList = new ArrayList<>();
        commandsList.add(new AddNewPet(consoleUI));
        commandsList.add(new CheckClass(consoleUI));
        commandsList.add(new FindById(consoleUI));
        commandsList.add(new DeleteById(consoleUI));
        commandsList.add(new GetAllPet(consoleUI));
        commandsList.add(new SortByAge(consoleUI));
        commandsList.add(new SortByName(consoleUI));
        commandsList.add(new LearnNewCommand(consoleUI));
        commandsList.add(new Finish(consoleUI));
    }

    public String getMenu() {
        StringBuilder strMenu = new StringBuilder();
        strMenu.append("Выберите из списка необходимую комманду: \n");
        for (int i = 0; i < commandsList.size(); i++) {
            strMenu.append(i + 1);
            strMenu.append(". ");
            strMenu.append(commandsList.get(i).getOption());
            strMenu.append("\n");
        }
        return strMenu.toString();
    }

    public void execute(int choice) throws PetCreationException {
        Commands commands = commandsList.get(choice - 1);
        commands.execute();
    }

    public int getSize(){
        return commandsList.size();
    }
}
