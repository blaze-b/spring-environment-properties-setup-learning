package com.blazeb.config.vault;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.vault.core.VaultKeyValueOperations;
import org.springframework.vault.core.VaultKeyValueOperationsSupport.KeyValueBackend;
import org.springframework.vault.core.VaultTemplate;
import org.springframework.vault.core.VaultTransitOperations;
import org.springframework.vault.support.VaultResponseSupport;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

/**
 * Interactive KV + transit endpoints used when the {@code vault} profile is active.
 * Demonstrates Vault KV v2 and Transit operations via Spring Vault.
 */
@RestController
@RequestMapping("/vault")
@Profile("vault")
public class VaultKvController {

    private final VaultKeyValueOperations kv;
    private final VaultTransitOperations transit;
    private final VaultOpsProperties ops;

    public VaultKvController(VaultTemplate vaultTemplate, VaultOpsProperties ops) {
        this.kv = vaultTemplate.opsForKeyValue(ops.kvPath(), KeyValueBackend.KV_2);
        this.transit = vaultTemplate.opsForTransit();
        this.ops = ops;
    }

    @GetMapping("/kv")
    @SuppressWarnings("unchecked")
    public Map<String, Object> readKv(@RequestParam(defaultValue = "chapter-08-vault") String path) {
        VaultResponseSupport<Map<String, Object>> response =
                (VaultResponseSupport<Map<String, Object>>) (VaultResponseSupport<?>) kv.get(path, Map.class);
        if (response == null || response.getData() == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No secret at path " + path);
        }
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("path", path);
        body.put("data", response.getData());
        return body;
    }

    @PostMapping("/kv")
    public Map<String, Object> writeKv(
            @RequestParam(defaultValue = "chapter-08-vault") String path,
            @RequestBody Map<String, Object> secrets) {
        kv.put(path, secrets);
        return Map.of("written", true, "path", path);
    }

    @PostMapping("/transit/encrypt")
    public Map<String, String> encrypt(@RequestBody Map<String, String> body) {
        String plaintext = Optional.ofNullable(body.get("text")).orElseThrow();
        String ciphertext = transit.encrypt(ops.transitKey(), plaintext);
        return Map.of("ciphertext", ciphertext);
    }

    @PostMapping("/transit/decrypt")
    public Map<String, String> decrypt(@RequestBody Map<String, String> body) {
        String ciphertext = Optional.ofNullable(body.get("ciphertext")).orElseThrow();
        String plaintext = transit.decrypt(ops.transitKey(), ciphertext);
        return Map.of("text", plaintext);
    }
}
