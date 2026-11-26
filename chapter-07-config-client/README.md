# Chapter 7: Spring Cloud Config Client

[Previous: Chapter 6 — Config Server](../chapter-06-config-server/README.md) · [Next: Chapter 8 — Vault](../chapter-08-vault/README.md)

Consume configuration from the Config Server (Chapter 6) with a safe local fallback for tests/CI.

## What You Will Learn

- `spring.config.import=optional:configserver:...`
- Binding remote keys with `@ConfigurationProperties`
- Keeping CI green with `spring.cloud.config.enabled=false` by default

## How To Run

Terminal 1 — start the server (Chapter 6):

```bash
./mvnw -pl chapter-06-config-server spring-boot:run
```

Terminal 2 — start the client against it:

```bash
CONFIG_CLIENT_ENABLED=true ./mvnw -pl chapter-07-config-client spring-boot:run
curl http://localhost:8087/message
```

## Things To Try

1. Change `config-repo/config-client.yml`, restart the client, and confirm the new message
2. Hit `/actuator/refresh` after enabling `@RefreshScope` on a bean
3. Point at a wrong server URL with `fail-fast=true` and observe startup failure
