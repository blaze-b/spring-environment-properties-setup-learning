package com.blazeb.config.externalized;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "app.service")
public record ServiceProperties(String name, String apiKey, String featureFlag) {
}
