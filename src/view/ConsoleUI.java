package view;

import model.*;
import model.services.PetRepository;
import model.services.exceptions.NoRecException;
import model.services.exceptions.PetCreationException;
import presenter.Presenter;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ConsoleUI implements View {
    private Scanner scanner;
    private Presenter presenter;
    private PetRepository petRepository;
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
    public void start() throws PetCreationException, NoRecException {
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

    public void addNewPet() throws PetCreationException {
        System.out.println("Укажете имя:");
        String name = scanner.nextLine();
        System.out.println("Выберите вид животного: 1 - кот, 2 - собака, 3 - хомяк, 4 - лошадь, 5 - верблюд, 6 - ослик");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                pets.add(new Cat(name, null, null, null));
                break;
            case 2:
                pets.add(new Dog(name, null, null, null));
                break;
            case 3:
                pets.add(new Hamster(name, null, null, null));
                break;
            case 4:
                pets.add(new Horse(name, null, null, null));
                break;
            case 5:
                pets.add(new Camel(name, null, null, null));
                break;
            case 6:
                pets.add(new Donkey(name, null, null, null));
                break;
            default:
                System.out.println("Некорректный выбор.");
        }
        System.out.println("Укажите дату гг/мм/дд:");
        LocalDate date = LocalDate.of(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        System.out.println(date.format(dtf));
        System.out.println(scanner.nextLine());
        //TODO
//        checkBirthdayDate(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
        System.out.println("Введите команды через запятую:");
        String input = scanner.nextLine();
        String[] commandsArray = input.split(", ");
        ArrayList<String> commandsList = new ArrayList<>(Arrays.asList(commandsArray));
        System.out.println("Список команд: " + commandsList);
        System.out.println("Запись внесена ---> " + "\n" +  "имя: " + name + "\n" + "Дата рождения: " + date.format(dtf) + "\n" + "Список команд: " + commandsList);
        System.out.println();
        presenter.addNewPet(name, date, null, commandsList);
    }


    //TODO нет реализации learnNewCommand (не добавляет/не запоминает)
    public void learnNewCommand() {//
        System.out.println("Укажите новую команду: ");
        String newCommand = scanner.nextLine();
      
        if (!newCommand.isEmpty()) {
            presenter.learnNewCommand(newCommand);
            System.out.println("Команда '" + newCommand + "' успешно добавлена и выучена");
        } else {
            System.out.println("Ошибка: команда не может быть пустой");
        }
    }

    //TODO нет реализации
    public void checkClass() {
        presenter.checkClass();
    }

    public void deleteById() {
        System.out.println("Введите ID для удаления: ");
        String strID = scanner.nextLine();
        int id = Integer.parseInt(strID);
        presenter.deleteById(id);
        System.out.println("Запись о животном удалена из реестра");
        presenter.getPetList();
    }

    //TODO проверить на список обновленных команд 
    public void findById() {
        System.out.println("Введите ID: ");
        String strID  = scanner.nextLine();
        int idPet = Integer.parseInt(strID);
        System.out.println(presenter.findById(idPet));

        String commands = presenter.getCommands(); // Получаем текущий список команд из объекта Menu
        System.out.println("Список доступных команд:");
        for (int i = 0; i < commands.length(); i++) {
            System.out.println(commands.charAt(i));
        }
    }

    // TODO доработать exception
    public void getAllPet() throws NoRecException {
        String petList = presenter.getPetList();
        if (petList.isEmpty()) {
            throw new NoRecException("Нет доступных записей о питомцах");
        } else {
//            presenter.getPetList();
            System.out.println(petList);
        }
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
        System.out.println("Вы вышли из приложения");
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

    //TODO нереализованное исключение
    public void checkBirthdayDate(int year, int month, int day) throws IllegalArgumentException {
        try {
            LocalDate birthday = LocalDate.of(year, month, day);
            LocalDate currentDate = LocalDate.now();
            if (year > currentDate.getYear() || month < 1 || month > 12 || day < 1 || day > birthday.lengthOfMonth()) {
                throw new IllegalArgumentException("Некорректная дата рождения");
            }
        } catch (DateTimeException e) {
            System.err.println("Ошибка при создании LocalDate: " + e.getMessage());

        }
    }
}
