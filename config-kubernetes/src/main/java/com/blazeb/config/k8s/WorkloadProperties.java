package com.blazeb.config.k8s;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "workload")
public record WorkloadProperties(String environmentName, String dbUrl, String dbPassword) {
}
