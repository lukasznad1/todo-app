package pl.boot.app.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.boot.app.model.Task;
import pl.boot.app.repository.TaskRepository;

import javax.validation.Valid;
import java.util.List;


@Slf4j
@RestController
@RequiredArgsConstructor
public class TaskController {

    private final TaskRepository repository;

    @GetMapping(value = "/tasks", params = {"!sort", "!page", "!size"})
    ResponseEntity<List<Task>> readAllTask() {
        log.warn("Exposing all the tasks!");
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping(value = "/tasks")
    ResponseEntity<List<Task>> readAllTask(Pageable pageable) {
        log.warn("Custom pageable");
        return ResponseEntity.ok(repository.findAll(pageable).getContent());
    }

    @GetMapping (value = "/tasks/{id}")
    ResponseEntity<Task> readTask(@PathVariable Integer id) {



        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }


        return null;
    }



    @PutMapping(value = "/tasks/{id}")
    ResponseEntity<?> updateTask(@PathVariable Integer id, @RequestBody @Valid Task toUpdate) {

        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        toUpdate.setId(id);
        repository.save(toUpdate);
        return ResponseEntity.noContent().build();
    }
}
