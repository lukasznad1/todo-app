package pl.boot.app.logic;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.boot.app.model.Task;
import pl.boot.app.repository.TaskGroupRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TempService {

    private final TaskGroupRepository repository;

    List<String> temp() {
        return repository.findAll().stream()
                .flatMap(taskGroup -> taskGroup.getTasks().stream())
                .map(Task::getDescription)
                .collect(Collectors.toList());
    }
}
