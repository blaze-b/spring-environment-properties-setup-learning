package com.blazeb.config.externalized;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;

@SpringBootTest
class ExternalizedConfigApplicationTests {

    @DynamicPropertySource
    static void higherPrecedence(DynamicPropertyRegistry registry) {
        registry.add("app.service.api-key", () -> "from-dynamic-property-source");
    }

    @Autowired
    private ServiceProperties service;

    @Test
    void importAndDynamicOverridesApply() {
        assertThat(service.apiKey()).isEqualTo("from-dynamic-property-source");
        assertThat(service.featureFlag()).isEqualTo("from-config-import");
        assertThat(service.name()).isEqualTo("externalized-demo");
    }
}
