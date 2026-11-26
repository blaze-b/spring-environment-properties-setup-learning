package com.blazeb.config.propertiesyaml;

import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfoController {

    private final AppInfoProperties appInfo;

    public InfoController(AppInfoProperties appInfo) {
        this.appInfo = appInfo;
    }

    @GetMapping("/info")
    public Map<String, Object> info() {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("displayName", appInfo.displayName());
        body.put("ownerEmail", appInfo.ownerEmail());
        body.put("maxRetries", appInfo.maxRetries());
        return body;
    }
}
