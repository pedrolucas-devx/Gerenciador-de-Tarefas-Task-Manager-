import model.Task;
import service.TaskService;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class TaskServiceTest {

    @Test
    public void testAddAndCompleteTask() {
        TaskService service = new TaskService();
        Task task = new Task("Teste", "Descrição", LocalDate.now());

        service.addTask(task);
        assertEquals(1, service.getAllTasks().size());

        service.markTaskAsCompleted(0);
        assertTrue(service.getAllTasks().get(0).isCompleted());
    }
}