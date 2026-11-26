package com.blazeb.config.vault;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class VaultLearningApplicationTests {

    @Autowired
    private DemoSecretsProperties secrets;

    @Test
    void usesLocalSecretsWhenVaultDisabled() {
        assertThat(secrets.username()).isEqualTo("local-user");
        assertThat(secrets.password()).isEqualTo("local-only-changeme");
        assertThat(secrets.apiKey()).isEqualTo("local-api-key-changeme");
    }
}
