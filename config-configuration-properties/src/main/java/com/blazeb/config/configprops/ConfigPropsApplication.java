package com.blazeb.config.configprops;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class ConfigPropsApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConfigPropsApplication.class, args);
    }
}
