package pl.boot.app.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import pl.boot.app.model.Task;
import pl.boot.app.model.TaskGroup;
import pl.boot.app.repository.TaskGroupRepository;
import pl.boot.app.repository.TaskRepository;

import javax.validation.Valid;
import java.util.List;


@Slf4j
@RestController
@RequiredArgsConstructor
public class TaskController {

    private final TaskRepository taskRepository;
    private final TaskGroupRepository taskGroupRepository;

    @GetMapping(value = "/tasks", params = {"!sort", "!page", "!size"})
    ResponseEntity<List<Task>> readAllTask() {
        log.warn("Exposing all the tasks!");
        return ResponseEntity.ok(taskRepository.findAll());
    }

    @GetMapping(value = "/tasks/group/{groupId}")
    ResponseEntity<TaskGroup> readTaskGroup(@PathVariable Integer groupId) {
        return taskGroupRepository.findById(groupId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping(value = "/tasks")
    ResponseEntity<List<Task>> readAllTask(Pageable pageable) {
        log.warn("Custom pageable");
        return ResponseEntity.ok(taskRepository.findAll(pageable).getContent());
    }

    @GetMapping(value = "/tasks/{id}")
    ResponseEntity<Task> readTask(@PathVariable Integer id) {

        return taskRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping(value = "/task")
    ResponseEntity<Task> createTask(@RequestBody @Valid Task task) {
        return ResponseEntity.ok(taskRepository.save(task));
    }


    @Transactional
    @PutMapping(value = "/tasks/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Integer id, @RequestBody Task toUpdate) {

        if (!taskRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        taskRepository.findById(id)
                .ifPresent(task -> task.updateFrom(toUpdate));
        return ResponseEntity.noContent().build();
    }

    @Transactional
    @PatchMapping(value = "/tasks/{id}")
    public ResponseEntity<Task> toggleTask(@PathVariable Integer id) {

        if (!taskRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        taskRepository.findById(id)
                .ifPresent(task -> task.setDone(!task.isDone()));
        return ResponseEntity.noContent().build();
    }
}
