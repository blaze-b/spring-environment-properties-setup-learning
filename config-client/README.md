# Spring Cloud Config Client

[Previous: `config-server`](../config-server/README.md) · [Next: `config-vault`](../config-vault/README.md)

Consume configuration from the Config Server (`config-server`) with a safe local fallback for tests/CI.

## What You Will Learn

- `spring.config.import=optional:configserver:...`
- Binding remote keys with `@ConfigurationProperties`
- Keeping CI green with `spring.cloud.config.enabled=false` by default

## How To Run

Terminal 1 — start the server (`config-server`):

```bash
./mvnw -pl config-server spring-boot:run
```

Terminal 2 — start the client against it:

```bash
CONFIG_CLIENT_ENABLED=true ./mvnw -pl config-client spring-boot:run
curl http://localhost:8087/message
```

## Things To Try

1. Change `config-repo/config-client.yml`, restart the client, and confirm the new message
2. Hit `/actuator/refresh` after enabling `@RefreshScope` on a bean
3. Point at a wrong server URL with `fail-fast=true` and observe startup failure
