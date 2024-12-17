package com.todolist;

import java.util.ArrayList;
import java.util.Scanner;

public class RemoveTask {
    public static void removeTask(ArrayList<Task> tasks, Scanner scanner) {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available to remove.");
            return;
        }

        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i).getTitle());
        }

        System.out.print("Enter task number to remove: ");
        int taskNumber = Integer.parseInt(scanner.nextLine());

        if (taskNumber > 0 && taskNumber <= tasks.size()) {
            tasks.remove(taskNumber - 1);
            System.out.println("Task removed successfully.");
        } else {
            System.out.println("Invalid task number.");
        }
    }
}
