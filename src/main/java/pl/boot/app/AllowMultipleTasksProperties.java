package pl.boot.app;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

@Getter
@Setter
@Configuration
@ConfigurationProperties("task.template")
@Validated
public class AllowMultipleTasksProperties {

    private boolean allowMultipleTasksFromTemplate;
}
