package view;

import model.*;
import presenter.Presenter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ConsoleUI implements View {
    private Scanner scanner;
    private Presenter presenter;
    private boolean flag;
    private Menu menu;
    private List<Pet> pets = new ArrayList<>();

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter((View) this);
        flag = true;
        menu = new Menu(this);
    }

    @Override
    public void start() {
        while (flag) {
            System.out.println(menu.getMenu());
            String command = scanner.nextLine();
            if(checkChoice(command)){
                if (checkChoice(command)){
                    menu.execute(Integer.parseInt(command));
                }
            } else {
                System.out.println("Такой команды нет. \nПопробуйте еще раз ввести данные");
            }
        }
    }
    //TODO нет реализации checkClass
    public void checkClass() {

    }

    public void addNewPet() {
        System.out.println("Укажете имя:");
        String name = scanner.nextLine();
        System.out.println("Выберите вид животного: 1 - кот, 2 - собака, 3 - хомяк, 4 - лошадь, 5 - верблюд, 6 - ослик");
        int choice = scanner.nextInt();
        //TODO доработать
        switch (choice) {
            case 1:
                pets.add(new Cat(name));
                break;
            case 2:
                pets.add(new Dog(name));
                break;
            case 3:
                pets.add(new Hamster(name));
                break;
            case 4:
                pets.add(new Horse(name));
                break;
            case 5:
                pets.add(new Camel(name));
                break;
            case 6:
                pets.add(new Donkey(name));
                break;
            default:
                System.out.println("Некорректный выбор.");
        }

        System.out.println("Укажите дату гг/мм/дд:");
        LocalDate date = LocalDate.of(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        System.out.println(date.format(dtf));

        System.out.println(scanner.nextLine());
        //TODO доработать
        System.out.println("Введите команды через запятую:");
        String input = scanner.nextLine();
        String[] commandsArray = input.split(",");
        ArrayList<String> commandsList = new ArrayList<>(Arrays.asList(commandsArray));
        System.out.println("Список команд: " + commandsList);

        System.out.println("Запись внесена ---> " + "\n" +  "имя: " + name + "\n"  + "\n" + "Дата рождения: " + date.format(dtf) + "\n" + "Список команд: " + commandsList);
        System.out.println();
        presenter.addNewPet(name, date, null, commandsList);
    }
    //TODO нет реализации learnNewCommand
    public void learnNewCommand() {
        
    }
    //TODO нет реализации getListOfCommands
    // по имени животного поиск
    public void getListOfCommands() {

    }

    public void deleteById() {
        System.out.println("Введите ID для удаления: ");
        String strID = scanner.nextLine();
        int id = Integer.parseInt(strID);
        presenter.deleteById(id);
        System.out.println("Запись о животном удалена из реестра");
        presenter.getPetList();
    }

    public void findById() {
        System.out.println("Введите ID: ");
        String strID  = scanner.nextLine();
        int idPet = Integer.parseInt(strID);
        System.out.println(presenter.findById(idPet));
    }

    public void getAllPet() {
        presenter.getPetList();
    }

    public void sortByAge() {
        presenter.getComparatorByDateBirth();
        presenter.getPetList();
    }

    public void sortByName() {
        presenter.getComparatorByName();
        presenter.getPetList();
    }

    public void finish() {
        System.out.println("Exit");
        flag = false;
    }

    private boolean checkChoice(String choiceStr) {
        if (choiceStr.matches("[0-9]*")) {
            int choice = Integer.parseInt(choiceStr);
            return (choice >= 1  && choice <= menu.getSize());
        }
        return false;
    }

    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);
    }
}
