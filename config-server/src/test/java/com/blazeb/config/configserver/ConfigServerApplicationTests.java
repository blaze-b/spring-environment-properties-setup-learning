package com.blazeb.config.configserver;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ConfigServerApplicationTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void servesNativeConfigForClient() {
        ResponseEntity<String> response = restTemplate.getForEntity("/config-client/default", String.class);
        assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
        assertThat(response.getBody()).contains("Hello from Config Server (default)");
    }
}
