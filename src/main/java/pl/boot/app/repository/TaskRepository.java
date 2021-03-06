package pl.boot.app.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import pl.boot.app.model.Task;

import java.util.List;
import java.util.Optional;


public interface TaskRepository {

    List<Task> findAll();

    Optional<Task> findById(Integer id);

    boolean existsById(Integer id);

    Task save(Task entity);

    Page<Task> findAll(Pageable pageable);

    List<Task> findByDone(@Param("state") boolean state);
}
