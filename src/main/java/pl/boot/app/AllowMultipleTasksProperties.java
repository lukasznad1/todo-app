package pl.boot.app;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties("task.template")
public class AllowMultipleTasksProperties {

    private boolean allowMultipleTasksFromTemplate;
}
