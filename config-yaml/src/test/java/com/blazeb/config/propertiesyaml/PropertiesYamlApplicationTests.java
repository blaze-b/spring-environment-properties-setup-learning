package com.blazeb.config.propertiesyaml;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PropertiesYamlApplicationTests {

    @DynamicPropertySource
    static void overridePort(DynamicPropertyRegistry registry) {
        registry.add("server.port", () -> 0);
    }

    @Autowired
    private AppInfoProperties appInfo;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void bindsRelaxedYamlKeys() {
        assertThat(appInfo.displayName()).isEqualTo("Properties vs YAML Demo");
        assertThat(appInfo.ownerEmail()).isEqualTo("learner@example.com");
        assertThat(appInfo.maxRetries()).isEqualTo(3);
    }

    @Test
    void exposesInfoEndpoint() {
        ResponseEntity<String> response = restTemplate.getForEntity("/info", String.class);
        assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
        assertThat(response.getBody()).contains("Properties vs YAML Demo");
    }
}
