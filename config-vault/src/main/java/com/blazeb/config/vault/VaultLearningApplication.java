package com.blazeb.config.vault;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class VaultLearningApplication {
    public static void main(String[] args) {
        SpringApplication.run(VaultLearningApplication.class, args);
    }
}
