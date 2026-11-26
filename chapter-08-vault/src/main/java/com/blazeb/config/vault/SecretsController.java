package com.blazeb.config.vault;

import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecretsController {

    private final DemoSecretsProperties secrets;

    public SecretsController(DemoSecretsProperties secrets) {
        this.secrets = secrets;
    }

    @GetMapping("/secrets/summary")
    public Map<String, Object> summary() {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("username", secrets.username());
        body.put("passwordConfigured", secrets.password() != null && !secrets.password().isBlank());
        body.put("apiKeyConfigured", secrets.apiKey() != null && !secrets.apiKey().isBlank());
        return body;
    }
}
