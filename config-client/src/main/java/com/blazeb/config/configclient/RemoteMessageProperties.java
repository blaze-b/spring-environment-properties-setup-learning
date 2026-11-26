package com.blazeb.config.configclient;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "app")
public record RemoteMessageProperties(String message, Feature feature) {
    public record Feature(boolean widgetsEnabled) {
    }
}
