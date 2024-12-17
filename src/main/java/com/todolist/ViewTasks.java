package com.todolist;

import java.util.ArrayList;

public class ViewTasks {
    public static void displayTasks(ArrayList<Task> tasks) {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println("\nTask " + (i + 1) + ":");
                System.out.println(tasks.get(i));
            }
        }
    }
}
