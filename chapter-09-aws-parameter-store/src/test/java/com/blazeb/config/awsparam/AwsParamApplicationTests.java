package com.blazeb.config.awsparam;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AwsParamApplicationTests {

    @Autowired
    private ParamStoreDemoProperties demo;

    @Autowired
    private SsmPathProperties ssm;

    @Test
    void localClasspathValuesWhenParamStoreDisabled() {
        assertThat(demo.greeting()).contains("local classpath");
        assertThat(ssm.prefix()).isEqualTo("/config");
        assertThat(ssm.applicationName()).isEqualTo("chapter-09-aws-parameter-store");
    }
}
