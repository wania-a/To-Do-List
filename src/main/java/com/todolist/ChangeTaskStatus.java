package com.todolist;

import java.util.ArrayList;
import java.util.Scanner;

public class ChangeTaskStatus {
    public static void markTaskComplete(ArrayList<Task> tasks, Scanner scanner) {
        updateStatus(tasks, scanner, "Complete");
    }

    public static void markTaskPending(ArrayList<Task> tasks, Scanner scanner) {
        updateStatus(tasks, scanner, "Pending");
    }

    private static void updateStatus(ArrayList<Task> tasks, Scanner scanner, String status) {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available to update.");
            return;
        }

        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i).getTitle());
        }

        System.out.print("Enter task number to mark as " + status.toLowerCase() + ": ");
        int taskNumber = Integer.parseInt(scanner.nextLine());

        if (taskNumber > 0 && taskNumber <= tasks.size()) {
            tasks.get(taskNumber - 1).setStatus(status);
            System.out.println("Task marked as " + status.toLowerCase() + ".");
        } else {
            System.out.println("Invalid task number.");
        }
    }
}
