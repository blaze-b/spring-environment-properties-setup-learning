package com.blazeb.config.awsparam;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Demo keys that would typically be supplied from AWS SSM
 * under a path such as {@code /config/{application}/...}.
 */
@ConfigurationProperties(prefix = "demo.aws")
public record ParamStoreDemoProperties(String greeting, String dbPassword) {
}
