package com.blazeb.config.awsparam;

import io.awspring.cloud.autoconfigure.config.parameterstore.ParameterStoreAutoConfiguration;
import io.awspring.cloud.autoconfigure.core.AwsAutoConfiguration;
import io.awspring.cloud.autoconfigure.core.CredentialsProviderAutoConfiguration;
import io.awspring.cloud.autoconfigure.core.RegionProviderAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication(exclude = {
        AwsAutoConfiguration.class,
        CredentialsProviderAutoConfiguration.class,
        RegionProviderAutoConfiguration.class,
        ParameterStoreAutoConfiguration.class
})
@ConfigurationPropertiesScan
public class AwsParamApplication {

    public static void main(String[] args) {
        SpringApplication.run(AwsParamApplication.class, args);
    }
}
