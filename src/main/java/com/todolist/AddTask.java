package com.todolist;

import java.sql.SQLException;
import java.util.Scanner;

public class AddTask {
    public static void createTask(TaskDAO taskDAO, Scanner scanner) {
        try {
            System.out.print("Enter task title: ");
            String title = scanner.nextLine();

            System.out.print("Enter task description (optional): ");
            String description = scanner.nextLine();

            System.out.print("Enter task deadline (YYYY-MM-DD, optional): ");
            String deadline = scanner.nextLine();

            Task task = new Task(title);
            task.setDescription(description.isEmpty() ? null : description);
            task.setDeadline(deadline.isEmpty() ? null : deadline);

            taskDAO.addTask(task);
            System.out.println("Task added successfully to the database.");
        } catch (SQLException e) {
            System.err.println("Error adding task to the database: " + e.getMessage());
        }
    }
}
