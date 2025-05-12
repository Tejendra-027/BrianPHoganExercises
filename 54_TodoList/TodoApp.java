import java.io.*;
import java.nio.file.Files;
import java.util.*;

public class TodoApp {
    private static final String FILE_NAME = "tasks.txt";

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Task");
            System.out.println("2. List Tasks");
            System.out.println("3. Remove Task");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addTasks(scanner);
                    break;
                case "2":
                    listTasks();
                    break;
                case "3":
                    removeTask(scanner);
                    break;
                case "4":
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private static void addTasks(Scanner scanner) throws IOException {
        List<String> tasks = loadTasks();

        while (true) {
            System.out.print("Enter a task (leave blank to stop): ");
            String task = scanner.nextLine().trim();
            if (task.isEmpty()) break;
            tasks.add(task);
        }

        saveTasks(tasks);
    }

    private static void listTasks() throws IOException {
        List<String> tasks = loadTasks();
        if (tasks.isEmpty()) {
            System.out.println("No tasks.");
            return;
        }

        System.out.println("\nYour Tasks:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }

    private static void removeTask(Scanner scanner) throws IOException {
        List<String> tasks = loadTasks();
        listTasks();

        if (tasks.isEmpty()) return;

        System.out.print("Enter the number of the task to remove: ");
        try {
            int index = Integer.parseInt(scanner.nextLine()) - 1;
            if (index < 0 || index >= tasks.size()) {
                System.out.println("Invalid task number.");
                return;
            }
            tasks.remove(index);
            saveTasks(tasks);
            System.out.println("Task removed.");
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number.");
        }
    }

    private static List<String> loadTasks() throws IOException {
        File file = new File(FILE_NAME);
        if (!file.exists()) return new ArrayList<>();
        return new ArrayList<>(Files.readAllLines(file.toPath()));
    }

    private static void saveTasks(List<String> tasks) throws IOException {
        PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME));
        for (String task : tasks) {
            writer.println(task);
        }
        writer.close();
    }
}
