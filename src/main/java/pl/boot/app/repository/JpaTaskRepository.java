package pl.boot.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.boot.app.model.Task;

@Repository
interface JpaTaskRepository extends TaskRepository, JpaRepository<Task, Integer> {
}
