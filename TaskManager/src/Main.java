import model.Task;
import service.TaskService;
import util.FileUtils;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    private static final String FILE = "tasks.txt";

    public static void main(String[] args) {
        TaskService service = new TaskService();
        Scanner scanner = new Scanner(System.in);

        try {
            service.getAllTasks().addAll(FileUtils.loadTasks(FILE));
        } catch (Exception e) {
            System.out.println("Iniciando com lista vazia.");
        }

        while (true) {
            System.out.println("\n1. Adicionar tarefa");
            System.out.println("2. Listar tarefas");
            System.out.println("3. Marcar como concluída");
            System.out.println("4. Sair");
            System.out.print("Escolha: ");

            switch (scanner.nextLine()) {
                case "1" -> {
                    System.out.print("Título: ");
                    String title = scanner.nextLine();
                    System.out.print("Descrição: ");
                    String desc = scanner.nextLine();
                    System.out.print("Data (YYYY-MM-DD): ");
                    LocalDate date = LocalDate.parse(scanner.nextLine());
                    service.addTask(new Task(title, desc, date));
                }
                case "2" -> {
                    int i = 0;
                    for (Task task : service.getAllTasks()) {
                        System.out.println(i++ + ": " + task);
                    }
                }
                case "3" -> {
                    System.out.print("ID da tarefa: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    service.markTaskAsCompleted(id);
                }
                case "4" -> {
                    try {
                        FileUtils.saveTasks(service.getAllTasks(), FILE);
                        System.out.println("Tarefas salvas. Encerrando...");
                    } catch (Exception e) {
                        System.out.println("Erro ao salvar.");
                    }
                    return;
                }
            }
        }
    }
}