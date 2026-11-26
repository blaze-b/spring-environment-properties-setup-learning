# Chapter 8: HashiCorp Vault

[Previous: Chapter 7 — Config Client](../chapter-07-config-client/README.md) · [Next: Chapter 9 — AWS Parameter Store](../chapter-09-aws-parameter-store/README.md)

Run HashiCorp Vault in Docker (dev mode) and load secrets with **Spring Cloud Vault**.

## Background

Concepts aligned with the public [`vault-demo-training`](https://github.com/blaze-b/vault-demo-training) sample (Spring Cloud Vault TOKEN auth, KV read, transit encrypt/decrypt), rewritten here for Spring Boot 3 with a single stack: Spring Cloud Vault + `docker compose` Vault `-dev`. Older alternate Vault clients are not carried forward.

## What You Will Learn

- Dev-mode Vault with a documented learning token (`root-token-for-dev-only`)
- Enabling the `vault` profile so Spring Cloud Vault populates the `Environment`
- KV v2 read/write and Transit encrypt/decrypt endpoints

## How To Run

### Local fallback (no Docker — default)

```bash
./mvnw -pl chapter-08-vault spring-boot:run
curl http://localhost:8088/secrets/summary
```

### With Vault

```bash
cd chapter-08-vault
docker compose up -d
# optional seed (needs vault CLI):
# VAULT_ADDR=http://127.0.0.1:8200 VAULT_TOKEN=root-token-for-dev-only ./docker/seed-vault.sh

SPRING_PROFILES_ACTIVE=vault ./mvnw -pl chapter-08-vault spring-boot:run
curl http://localhost:8088/secrets/summary
curl "http://localhost:8088/vault/kv?path=chapter-08-vault"
```

**Security:** `root-token-for-dev-only` is a learning placeholder for Vault `-dev` only. Never use it outside this chapter.

## Things To Try

1. `POST /vault/kv` with a JSON body, then read it back
2. Encrypt a string with `/vault/transit/encrypt` and decrypt it
3. Compare this chapter with Chapter 5 (Jasypt) and Chapter 9 (AWS SSM)
