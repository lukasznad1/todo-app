package pl.boot.app.model;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table (name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotBlank (message = "Task's description must be not null")
    private String description;
    private boolean done;
}
