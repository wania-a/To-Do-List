package com.todolist;

import java.util.Scanner;

public class AddTask {
    public static Task createTask(Scanner scanner) {
        System.out.print("Enter task title: ");
        String title = scanner.nextLine();
        Task task = new Task(title);

        System.out.print("Enter task description (optional): ");
        task.setDescription(scanner.nextLine());

        System.out.print("Enter task deadline (optional): ");
        task.setDeadline(scanner.nextLine());

        System.out.println("Task added successfully.");
        return task;
    }
}