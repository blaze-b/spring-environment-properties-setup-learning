package com.blazeb.config.jasypt;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(properties = {
        "jasypt.encryptor.password=changeme",
        "app.secret.database-password=plain-for-test",
        "app.secret.api-token=token-for-test"
})
class JasyptApplicationTests {

    @Autowired
    private SecretProperties secrets;

    @Test
    void decryptsOrAcceptsPlainValuesInTests() {
        assertThat(secrets.databasePassword()).isEqualTo("plain-for-test");
        assertThat(secrets.apiToken()).isEqualTo("token-for-test");
    }
}
