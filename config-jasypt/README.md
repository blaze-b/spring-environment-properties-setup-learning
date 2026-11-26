# Jasypt Encrypted Properties

[Previous: `config-externalized`](../config-externalized/README.md) · [Next: `config-server`](../config-server/README.md)

Encrypt sensitive values in property files with Jasypt. The master password stays outside git.

## What You Will Learn

- Wrapping secrets as `ENC(...)` in YAML
- Supplying `JASYPT_ENCRYPTOR_PASSWORD` at runtime
- Generating ciphertext with the Jasypt Maven plugin

## Key Concepts

| Idea | Detail |
| --- | --- |
| Master password | Never commit it; use env / CI secrets |
| Algorithm | `PBEWITHHMACSHA512ANDAES_256` with random IV |
| Learning password | `changeme` only |

## How To Run

```bash
export JASYPT_ENCRYPTOR_PASSWORD=changeme
./mvnw -pl config-jasypt spring-boot:run
curl http://localhost:8085/secrets
```

### Generate New Ciphertext

```bash
./mvnw -pl config-jasypt jasypt:encrypt-value \
  -Djasypt.encryptor.password=changeme \
  -Djasypt.plugin.value=super-secret-db-password
```

Paste the printed `ENC(...)` into `application.yml`.

## Things To Try

1. Start without `JASYPT_ENCRYPTOR_PASSWORD` and watch decryption fail
2. Encrypt a new API token and replace `app.secret.api-token`
3. Compare Jasypt (in-repo ciphertext) with Vault (`config-vault`) for production secrets
