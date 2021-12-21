package pl.boot.app.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.boot.app.AllowMultipleTasksProperties;

@RestController
@RequiredArgsConstructor
public class InfoController {

    private final DataSourceProperties properties;
    private final AllowMultipleTasksProperties allowMultipleTasksProperties;

    @Value("${task.allowMultipleTasksFromTemplate}")
    private String myProp;

    @GetMapping (value = "/info/base-url")
    String url () {
        return properties.getUrl();
    }

    @GetMapping (value = "/info/isAllowMultipleTasks")
    boolean myProp () {
        return allowMultipleTasksProperties.isAllowMultipleTasksFromTemplate();
    }

}
