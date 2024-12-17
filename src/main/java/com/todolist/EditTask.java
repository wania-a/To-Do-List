package com.todolist;

import java.util.ArrayList;
import java.util.Scanner;

public class EditTask {
    public static void editTask(ArrayList<Task> tasks, Scanner scanner) {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available to edit.");
            return;
        }

        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i).getTitle());
        }

        System.out.print("Enter task number to edit: ");
        int taskNumber = Integer.parseInt(scanner.nextLine());

        if (taskNumber > 0 && taskNumber <= tasks.size()) {
            Task task = tasks.get(taskNumber - 1);

            System.out.print("Enter new title (leave blank to keep current): ");
            String newTitle = scanner.nextLine();
            if (!newTitle.isBlank()) task.setTitle(newTitle);

            System.out.print("Enter new description (leave blank to keep current): ");
            String newDescription = scanner.nextLine();
            if (!newDescription.isBlank()) task.setDescription(newDescription);

            System.out.print("Enter new deadline (leave blank to keep current): ");
            String newDeadline = scanner.nextLine();
            if (!newDeadline.isBlank()) task.setDeadline(newDeadline);

            System.out.println("Task updated successfully.");
        } else {
            System.out.println("Invalid task number.");
        }
    }
}
