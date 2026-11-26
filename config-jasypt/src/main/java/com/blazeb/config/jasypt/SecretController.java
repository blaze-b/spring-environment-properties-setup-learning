package com.blazeb.config.jasypt;

import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecretController {

    private final SecretProperties secrets;

    public SecretController(SecretProperties secrets) {
        this.secrets = secrets;
    }

    @GetMapping("/secrets")
    public Map<String, Object> secrets() {
        Map<String, Object> body = new LinkedHashMap<>();
        // Return lengths only — never echo decrypted secrets in real apps.
        body.put("databasePasswordLength", secrets.databasePassword().length());
        body.put("apiTokenLength", secrets.apiToken().length());
        body.put("databasePasswordStartsWith", secrets.databasePassword().substring(0, Math.min(5, secrets.databasePassword().length())));
        return body;
    }
}
