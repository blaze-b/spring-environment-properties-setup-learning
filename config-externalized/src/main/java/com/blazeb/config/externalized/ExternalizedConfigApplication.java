package com.blazeb.config.externalized;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class ExternalizedConfigApplication {
    public static void main(String[] args) {
        SpringApplication.run(ExternalizedConfigApplication.class, args);
    }
}
