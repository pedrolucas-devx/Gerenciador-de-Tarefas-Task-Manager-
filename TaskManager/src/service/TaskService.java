package service;

import model.Task;
import java.util.ArrayList;
import java.util.List;

public class TaskService {
    private List<Task> tasks = new ArrayList<>();

    public void addTask(Task task) {
        tasks.add(task);
    }

    public List<Task> getPendingTasks() {
        return tasks.stream().filter(t -> !t.isCompleted()).toList();
    }

    public void markTaskAsCompleted(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).markAsCompleted();
        }
    }

    public List<Task> getAllTasks() {
        return tasks;
    }
}