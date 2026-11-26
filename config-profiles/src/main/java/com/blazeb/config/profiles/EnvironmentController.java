package com.blazeb.config.profiles;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnvironmentController {

    private final Environment environment;
    private final String datasourceUrl;
    private final String greeting;

    public EnvironmentController(
            Environment environment,
            @Value("${app.datasource.url}") String datasourceUrl,
            @Value("${app.greeting}") String greeting) {
        this.environment = environment;
        this.datasourceUrl = datasourceUrl;
        this.greeting = greeting;
    }

    @GetMapping("/environment")
    public Map<String, Object> environment() {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("activeProfiles", Arrays.asList(environment.getActiveProfiles()));
        body.put("greeting", greeting);
        body.put("datasourceUrl", datasourceUrl);
        return body;
    }
}
