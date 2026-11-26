package com.blazeb.config.configprops;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ConfigPropsApplicationTests {

    @Autowired
    private MailerProperties mailer;

    @Test
    void bindsAndValidatesMailerProperties() {
        assertThat(mailer.getHost()).isEqualTo("smtp.example.com");
        assertThat(mailer.getPort()).isEqualTo(587);
        assertThat(mailer.getRecipients()).containsExactly("ops@example.com", "oncall@example.com");
        assertThat(mailer.isStartTls()).isTrue();
    }
}
