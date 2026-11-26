package com.blazeb.config.awsparam;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Mirrors the path-style keys historically loaded from AWS SSM
 * (/config/{application}/...) in aws-secrets-boot-training / lymbyc.
 */
@ConfigurationProperties(prefix = "demo.aws")
public record ParamStoreDemoProperties(String greeting, String dbPassword) {
}
