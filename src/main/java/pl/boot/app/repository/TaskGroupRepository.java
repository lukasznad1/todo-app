package pl.boot.app.repository;

import pl.boot.app.model.TaskGroup;

import java.util.List;
import java.util.Optional;

public interface TaskGroupRepository {

    List<TaskGroup> findAll();

    boolean existsByDoneIsFalseAndProject_Id(Integer groupId);

    Optional<TaskGroup> findById(Integer id);

    TaskGroup save(TaskGroup entity);
}
