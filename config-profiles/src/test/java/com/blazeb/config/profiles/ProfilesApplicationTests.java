package com.blazeb.config.profiles;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("local")
class ProfilesApplicationTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    @SuppressWarnings("unchecked")
    void localProfileOverridesDefaults() {
        Map<String, Object> body = restTemplate.getForObject("/environment", Map.class);
        assertThat(body.get("greeting")).isEqualTo("Hello from the local profile");
        assertThat((String) body.get("datasourceUrl")).contains("local-learning");
        assertThat((List<String>) body.get("activeProfiles")).contains("local");
    }
}
