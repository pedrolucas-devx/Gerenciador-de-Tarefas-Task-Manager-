package model;

import java.time.LocalDate;

public class Task {
    private String title;
    private String description;
    private LocalDate dueDate;
    private boolean completed;

    public Task(String title, String description, LocalDate dueDate) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.completed = false;
    }

    public void markAsCompleted() {
        this.completed = true;
    }

    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public LocalDate getDueDate() { return dueDate; }
    public boolean isCompleted() { return completed; }

    public String toString() {
        return String.format("[%s] %s (até %s)%s",
                completed ? "X" : " ", title, dueDate, description.isEmpty() ? "" : " - " + description);
    }
}