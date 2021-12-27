package pl.boot.app.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table (name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank (message = "Task's description must be not null")
    private String description;
    private boolean done;

    private LocalDateTime deadline;

    @Getter (AccessLevel.PRIVATE)
    @Embedded
    private Audit audit;

    @ManyToOne
    @JoinColumn(name = "task_group_id")
    @JsonManagedReference
    private TaskGroup group;

    public void updateFrom(final Task source) {
        this.description = source.getDescription();
        this.done = source.isDone();
        this.deadline = source.getDeadline();
    }
}
