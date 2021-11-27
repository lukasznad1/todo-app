package pl.boot.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import pl.boot.app.model.Task;

@RepositoryRestResource
public interface TaskRepository extends JpaRepository<Task, Integer> {

    @Override
    @RestResource (exported = false)
    void deleteById(Integer integer);

    @Override
    @RestResource (exported = false)
    void delete(Task entity);
}
