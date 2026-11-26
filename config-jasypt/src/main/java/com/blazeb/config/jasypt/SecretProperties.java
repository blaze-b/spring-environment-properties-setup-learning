package com.blazeb.config.jasypt;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "app.secret")
public record SecretProperties(String databasePassword, String apiToken) {
}
