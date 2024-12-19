package com.todolist;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TaskDAO taskDAO = new TaskDAO(); // Initialize TaskDAO
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nTo-Do List Menu:");
            System.out.println("1. Add Task");
            System.out.println("2. View All Tasks");
            System.out.println("3. Remove Task");
            System.out.println("4. Mark Task as Complete");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = Integer.parseInt(scanner.nextLine());

            try {
                switch (choice) {
                    case 1 -> AddTask.createTask(taskDAO, scanner);
                    case 2 -> viewTasks(taskDAO);
                    case 3 -> removeTask(taskDAO, scanner);
                    case 4 -> updateTaskStatus(taskDAO, scanner);
                    case 5 -> {
                        System.out.println("Exiting application. Goodbye!");
                        return;
                    }
                    default -> System.out.println("Invalid choice. Please try again.");
                }
            } catch (SQLException e) {
                System.err.println("Error interacting with database: " + e.getMessage());
            }
        }
    }

    private static void viewTasks(TaskDAO taskDAO) throws SQLException {
        List<Task> tasks = taskDAO.getAllTasks();
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            tasks.forEach(System.out::println);
        }
    }

    private static void removeTask(TaskDAO taskDAO, Scanner scanner) throws SQLException {
        System.out.print("Enter task ID to remove: ");
        int id = Integer.parseInt(scanner.nextLine());
        taskDAO.removeTask(id);
        System.out.println("Task removed successfully.");
    }

    private static void updateTaskStatus(TaskDAO taskDAO, Scanner scanner) throws SQLException {
        System.out.print("Enter task ID to update status: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter new status (Pending/Complete): ");
        String status = scanner.nextLine();
        taskDAO.updateTaskStatus(id, status);
        System.out.println("Task status updated successfully.");
    }
}
