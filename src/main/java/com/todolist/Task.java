package com.todolist;

public class Task {
    private String title;
    private String description;
    private String deadline;
    private String status; 

    public Task(String title) {
        this.title = title;
        this.status = "Pending";
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Title: " + title +
                "\nDescription: " + (description != null ? description : "Not set") +
                "\nDeadline: " + (deadline != null ? deadline : "Not set") +
                "\nStatus: " + status;
    }
}
