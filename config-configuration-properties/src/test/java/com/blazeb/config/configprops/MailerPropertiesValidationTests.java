package com.blazeb.config.configprops;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.validation.ValidationAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;

class MailerPropertiesValidationTests {

    private final ApplicationContextRunner runner = new ApplicationContextRunner()
            .withUserConfiguration(EnableMailer.class)
            .withConfiguration(
                    org.springframework.boot.autoconfigure.AutoConfigurations.of(ValidationAutoConfiguration.class));

    @Test
    void failsWhenHostMissing() {
        runner.withPropertyValues("app.mailer.port=25", "app.mailer.recipients[0]=a@example.com")
                .run(context -> assertThat(context).hasFailed());
    }

    @EnableConfigurationProperties(MailerProperties.class)
    static class EnableMailer {
    }
}
