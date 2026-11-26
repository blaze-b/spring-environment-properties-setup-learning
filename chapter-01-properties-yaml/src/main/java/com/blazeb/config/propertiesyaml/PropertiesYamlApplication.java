package com.blazeb.config.propertiesyaml;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class PropertiesYamlApplication {

    public static void main(String[] args) {
        SpringApplication.run(PropertiesYamlApplication.class, args);
    }
}
