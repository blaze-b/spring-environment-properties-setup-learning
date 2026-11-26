package com.blazeb.config.k8s;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class KubernetesConfigApplication {
    public static void main(String[] args) {
        SpringApplication.run(KubernetesConfigApplication.class, args);
    }
}
