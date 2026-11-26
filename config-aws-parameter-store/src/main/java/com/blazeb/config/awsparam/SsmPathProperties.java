package com.blazeb.config.awsparam;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "app.ssm")
public record SsmPathProperties(String prefix, String applicationName, String region) {
}
