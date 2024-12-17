package com.todolist;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Task> tasks = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nTo-Do List Menu:");
            System.out.println("1. Add Task");
            System.out.println("2. Remove Task");
            System.out.println("3. Edit Task");
            System.out.println("4. Mark Task as Complete");
            System.out.println("5. Mark Task as Pending");
            System.out.println("6. View All Tasks");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> tasks.add(AddTask.createTask(scanner));
                case 2 -> RemoveTask.removeTask(tasks, scanner);
                case 3 -> EditTask.editTask(tasks, scanner);
                case 4 -> ChangeTaskStatus.markTaskComplete(tasks, scanner);
                case 5 -> ChangeTaskStatus.markTaskPending(tasks, scanner);
                case 6 -> ViewTasks.displayTasks(tasks);
                case 7 -> {
                    System.out.println("Exiting application. Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
