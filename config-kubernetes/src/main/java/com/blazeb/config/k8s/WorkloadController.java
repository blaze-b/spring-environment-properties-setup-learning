package com.blazeb.config.k8s;

import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WorkloadController {

    private final WorkloadProperties workload;

    public WorkloadController(WorkloadProperties workload) {
        this.workload = workload;
    }

    @GetMapping("/workload")
    public Map<String, Object> workload() {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("environmentName", workload.environmentName());
        body.put("dbUrl", workload.dbUrl());
        body.put("dbPasswordConfigured", workload.dbPassword() != null && !workload.dbPassword().isBlank());
        return body;
    }
}
