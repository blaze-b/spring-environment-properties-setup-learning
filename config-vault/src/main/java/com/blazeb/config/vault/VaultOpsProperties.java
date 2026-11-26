package com.blazeb.config.vault;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "vault.ops")
public record VaultOpsProperties(String kvPath, String transitKey) {
}
