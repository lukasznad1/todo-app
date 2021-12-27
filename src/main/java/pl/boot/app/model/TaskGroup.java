package pl.boot.app.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "task_groups")
public class TaskGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Task's description must be not null")
    private String description;
    private boolean done;

    @Getter(AccessLevel.NONE)
    @Embedded
    private Audit audit = new Audit();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "group")
    @JsonBackReference
    private Set<Task> tasks;

    @ManyToOne
    @JoinColumn (name = "project_id")
    private Project project;
}
