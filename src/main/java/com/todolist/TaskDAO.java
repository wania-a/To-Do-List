package com.todolist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TaskDAO {
    public void addTask(Task task) throws SQLException {
        String sql = "INSERT INTO tasks (title, description, deadline, status) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, task.getTitle());
            stmt.setString(2, task.getDescription());
            stmt.setString(3, task.getDeadline());
            stmt.setString(4, task.getStatus());
            stmt.executeUpdate();
        }
    }

    public void removeTask(int id) throws SQLException {
        String sql = "DELETE FROM tasks WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    public void updateTask(Task task) throws SQLException {
        String sql = "UPDATE tasks SET title = ?, description = ?, deadline = ?, status = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, task.getTitle());
            stmt.setString(2, task.getDescription());
            stmt.setString(3, task.getDeadline());
            stmt.setString(4, task.getStatus());
            stmt.setInt(5, task.getId());
            stmt.executeUpdate();
        }
    }

    public List<Task> getAllTasks() throws SQLException {
        List<Task> tasks = new ArrayList<>();
        String sql = "SELECT * FROM tasks";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Task task = new Task(rs.getString("title"));
                task.setId(rs.getInt("id"));
                task.setDescription(rs.getString("description"));
                task.setDeadline(rs.getString("deadline"));
                task.setStatus(rs.getString("status"));
                tasks.add(task);
            }
        }
        return tasks;
    }
    public void updateTaskStatus(int id, String status) throws SQLException {
        String sql = "UPDATE tasks SET status = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, status);
            stmt.setInt(2, id);
            stmt.executeUpdate();
        }
    }
}
