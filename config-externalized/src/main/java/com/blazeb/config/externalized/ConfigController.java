package com.blazeb.config.externalized;

import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigController {

    private final ServiceProperties service;

    public ConfigController(ServiceProperties service) {
        this.service = service;
    }

    @GetMapping("/config")
    public Map<String, Object> config() {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("name", service.name());
        body.put("apiKey", service.apiKey());
        body.put("featureFlag", service.featureFlag());
        return body;
    }
}
