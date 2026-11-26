package com.blazeb.config.propertiesyaml;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "app.info")
public record AppInfoProperties(
        String displayName,
        String ownerEmail,
        int maxRetries
) {
}
