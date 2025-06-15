package util;

import model.Task;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
    public static void saveTasks(List<Task> tasks, String filename) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Task task : tasks) {
                writer.write(task.getTitle() + ";" + task.getDescription() + ";" +
                        task.getDueDate() + ";" + task.isCompleted());
                writer.newLine();
            }
        }
    }

    public static List<Task> loadTasks(String filename) throws IOException {
        List<Task> tasks = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                Task task = new Task(parts[0], parts[1], LocalDate.parse(parts[2]));
                if (Boolean.parseBoolean(parts[3])) {
                    task.markAsCompleted();
                }
                tasks.add(task);
            }
        }
        return tasks;
    }
}