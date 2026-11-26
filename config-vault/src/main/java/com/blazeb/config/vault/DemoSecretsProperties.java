package com.blazeb.config.vault;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Bound from application.yml locally, or from Vault KV when the {@code vault} profile is active
 * (Spring Cloud Vault maps secret/data/{application} into the Environment).
 */
@ConfigurationProperties(prefix = "demo.secrets")
public record DemoSecretsProperties(String username, String password, String apiKey) {
}
