package pl.boot.app.start;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.boot.app.model.Task;
import pl.boot.app.repository.TaskRepository;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CommandLineAppStartupRunner implements CommandLineRunner {

    private final TaskRepository repository;

    @Override
    public void run(String... args) {
        createTaskList().forEach(repository::save);
    }

    private List<Task> createTaskList() {

        var t1 = new Task();
        t1.setId(1);
        t1.setDescription("first task");
        t1.setDone(true);

        var t2 = new Task();
        t2.setId(2);
        t2.setDescription("second task");
        t2.setDone(false);

        var t3 = new Task();
        t3.setId(3);
        t3.setDescription("third task");
        t3.setDone(true);

        return List.of(t1, t2, t3);
    }
}
