package com.blazeb.config.jasypt;

import static org.assertj.core.api.Assertions.assertThat;

import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.junit.jupiter.api.Test;

class JasyptEncryptionRoundTripTests {

    @Test
    void encryptDecryptRoundTrip() {
        PooledPBEStringEncryptor encryptor = createEncryptor("changeme");
        String cipher = encryptor.encrypt("super-secret-db-password");
        assertThat(encryptor.decrypt(cipher)).isEqualTo("super-secret-db-password");
        assertThat(cipher).isNotEqualTo("super-secret-db-password");
    }

    static PooledPBEStringEncryptor createEncryptor(String password) {
        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        config.setPassword(password);
        config.setAlgorithm("PBEWITHHMACSHA512ANDAES_256");
        config.setKeyObtentionIterations("1000");
        config.setPoolSize("1");
        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
        config.setIvGeneratorClassName("org.jasypt.iv.RandomIvGenerator");
        config.setStringOutputType("base64");
        encryptor.setConfig(config);
        return encryptor;
    }
}
