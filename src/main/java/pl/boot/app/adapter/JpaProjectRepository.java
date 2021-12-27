package pl.boot.app.adapter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.boot.app.model.Project;
import pl.boot.app.model.TaskGroup;
import pl.boot.app.repository.ProjectRepository;
import pl.boot.app.repository.TaskGroupRepository;

import java.util.List;

@Repository
public interface JpaProjectRepository extends ProjectRepository, JpaRepository<Project, Integer> {

    @Override
    @Query("from Project p join fetch p.steps")
    List<Project> findAll();

}
