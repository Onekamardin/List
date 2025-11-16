import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ToDoList {
    private List<String> tasks = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);


    public void run() {
        System.out.println("Добро пожаловать в менеджер задач!");


        while (true) {
            showMenu();
            int choice = getUserChoice();

            switch (choice) {
                case 0:
                    System.out.println("До свидания!");
                    return;
                case 1:
                    addTask();
                    break;
                case 2:
                    showTasks();
                    break;
                case 3:
                    removeTaskByNumber();
                    break;
                case 4:
                    removeTaskByName();
                    break;
                default:
                    System.out.println("Некорректный выбор. Попробуйте ещё раз.");
            }

            if (choice != 0) {
                showTasks();
            }
        }
    }

    private void showMenu() {
        System.out.println("\nВыберите операцию:");
        System.out.println("0. Выход из программы");
        System.out.println("1. Добавить дело");
        System.out.println("2. Показать дела");
        System.out.println("3. Удалить дело по номеру");
        System.out.println("4. Удалить дело по названию");
        System.out.print("Ваш выбор: ");
    }

    private int getUserChoice() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Пожалуйста, введите число: ");
            }
        }
    }

    private void addTask() {
        System.out.print("Введите название задачи: ");
        String task = scanner.nextLine();

        if (tasks.contains(task)) {
            System.out.println("Такое дело уже есть в списке!");
        } else {
            tasks.add(task);
            System.out.println("Добавлено!");
        }
    }

    private void showTasks() {
        if (tasks.isEmpty()) {
            System.out.println("Ваш список дел пуст.");
        } else {
            System.out.println("Ваш список дел:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    private void removeTaskByNumber() {
        if (tasks.isEmpty()) {
            System.out.println("Список дел пуст, удалять нечего.");
            return;
        }

        System.out.print("Введите номер для удаления: ");
        try {
            int number = Integer.parseInt(scanner.nextLine());
            if (number < 1 || number > tasks.size()) {
                System.out.println("Нет дела с таким номером.");
            } else {
                tasks.remove(number - 1);
                System.out.println("Удалено!");
            }
        } catch (NumberFormatException e) {
            System.out.println("Пожалуйста, введите число.");
        }
    }

    private void removeTaskByName() {
        if (tasks.isEmpty()) {
            System.out.println("Список дел пуст, удалять нечего.");
            return;
        }

        System.out.print("Введите задачу для удаления: ");
        String taskToRemove = scanner.nextLine();

        if (tasks.contains(taskToRemove)) {
            tasks.remove(taskToRemove);
            System.out.println("Удалено!");
        } else {
            System.out.println("Нет дела с таким названием.");
        }
    }

    public static void main(String[] args) {
        ToDoList toDoList = new ToDoList();
        toDoList.run();
    }
}
