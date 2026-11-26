package com.blazeb.config.configclient;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ConfigClientApplicationTests {

    @Autowired
    private RemoteMessageProperties props;

    @Test
    void usesLocalFallbackWhenConfigServerDisabled() {
        assertThat(props.message()).contains("Local fallback");
        assertThat(props.feature().widgetsEnabled()).isFalse();
    }
}
