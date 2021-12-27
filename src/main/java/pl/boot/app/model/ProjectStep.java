package pl.boot.app.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table (name = "project_steps")
public class ProjectStep {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Projects step's description must be not null")
    private String description;

    private int daysToDeadline;

    @ManyToOne
    @JoinColumn (name = "project_id")
    private Project project;

}
