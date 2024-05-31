import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;


public class ToDoList {
    private ArrayList<String> tasks;
    private Scanner scanner;

    public ToDoList() {
        tasks = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("===== To-Do List Menu =====");
        System.out.println("1. Add Task");
        System.out.println("2. Edit Task");
        System.out.println("3. View Task");
        System.out.println("4. Delete Task");
        System.out.println("5. Exit");
        System.out.println("===========================");
    }

    public void addTask() {
        System.out.print("Enter the task description: ");
        String taskDetails = scanner.nextLine();
        tasks.add(taskDetails);
    }

    public void viewTask() {
            System.out.println("===== Task Details =====");
            for (String task : tasks) {
                    System.out.println("Description: "+task);
            }
    }

    public void deleteTask() {
        System.out.print("Enter the task number you want to delete [0 index] : ");
        int index = scanner.nextInt();
        scanner.nextLine();

        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
            System.out.println("Task deleted successfully!");
        } else {
            System.out.println("Invalid task number.");
        }
    }

    public void editTask() {
        System.out.print("Enter the task number you want to edit : ");
        int index = scanner.nextInt();
        scanner.nextLine();

        if (index >= 1 && index <= tasks.size()) {
            System.out.print("Enter new task details: ");
            String newDetails = scanner.nextLine();
            tasks.set(index - 1, newDetails);
    }}

    public static void main(String[] args) {
        ToDoList toDoList = new ToDoList();

        boolean running = true;
        while (running) {
            toDoList.displayMenu();
            System.out.print("Enter your choice: ");
            try {
                int choice = toDoList.scanner.nextInt();
                toDoList.scanner.nextLine();

                switch (choice) {
                    case 1:
                        toDoList.addTask();
                        break;
                    case 2:
                        toDoList.editTask();
                        break;
                    case 3:
                        toDoList.viewTask();
                        break;
                    case 4:
                        toDoList.deleteTask();
                        break;
                    case 5:
                        running = false;
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                toDoList.scanner.nextLine();
            }
        }

        toDoList.scanner.close();
    }
}
