package pl.boot.app.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import pl.boot.app.repository.TaskRepository;


@Slf4j
@RepositoryRestController
@RequiredArgsConstructor
public class TaskController {

    private final TaskRepository taskRepository;

    @GetMapping (value = "tasks", params = {"!sort" , "!page", "!size"})
    ResponseEntity<?> readAllTask () {
        log.warn("Exposing all the tasks!");
        return ResponseEntity.ok(taskRepository.findAll());
    }

    @GetMapping (value = "tasks")
    ResponseEntity<?> readAllTask (Pageable pageable) {
        log.warn("Custom pageable");
        return ResponseEntity.ok(taskRepository.findAll(pageable));
    }
    
}
