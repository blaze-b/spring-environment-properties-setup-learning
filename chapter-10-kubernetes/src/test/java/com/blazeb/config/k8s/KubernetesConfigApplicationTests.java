package com.blazeb.config.k8s;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(properties = {
        "WORKLOAD_ENVIRONMENT_NAME=staging",
        "WORKLOAD_DB_URL=jdbc:postgresql://postgres:5432/config_learning",
        "WORKLOAD_DB_PASSWORD=changeme"
})
class KubernetesConfigApplicationTests {

    @Autowired
    private WorkloadProperties workload;

    @Test
    void bindsEnvVarsAsMountedByConfigMapAndSecret() {
        assertThat(workload.environmentName()).isEqualTo("staging");
        assertThat(workload.dbUrl()).contains("postgres");
        assertThat(workload.dbPassword()).isEqualTo("changeme");
    }
}
