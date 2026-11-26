# Spring Config Learning

Hands-on modules for Spring Boot **properties**, **profiles**, **externalised config**, and **secrets** (Jasypt, Spring Cloud Config, Vault, AWS Parameter Store, Kubernetes). Each module is a small runnable app with tests.

[![CI](https://github.com/blaze-b/spring-config-learning/actions/workflows/ci.yml/badge.svg)](https://github.com/blaze-b/spring-config-learning/actions/workflows/ci.yml)

## Intro (basics)

Spring Boot resolves configuration from many property sources. Later sources override earlier ones. A practical mental model for this repo:

1. Packaged `application.yml` / `.properties` (defaults)
2. Profile-specific files (`application-{profile}.yml`)
3. Imported sources (`spring.config.import`, Config Server, Vault, SSM)
4. OS environment variables and JVM system properties
5. Command-line arguments (highest common precedence for local overrides)

**Relaxed binding** maps `my.property-name`, `MY_PROPERTY_NAME`, and `my.propertyName` to the same Java field. Prefer `@ConfigurationProperties` for grouped, validated config over scattered `@Value` injections.

Never commit real secrets. This repo uses obvious placeholders (`changeme`, documented Vault **dev** tokens only).

## Modules

| Module | Covers | Link |
| --- | --- | --- |
| `config-yaml` | YAML nesting, `.properties` equivalents, relaxed binding | [README](config-yaml/README.md) |
| `config-profiles` | `local` / `dev` / `prod` files and env placeholders | [README](config-profiles/README.md) |
| `config-configuration-properties` | `@ConfigurationProperties` + Bean Validation | [README](config-configuration-properties/README.md) |
| `config-externalized` | Env vars, CLI, `config.import`, `.env.example` | [README](config-externalized/README.md) |
| `config-jasypt` | `ENC(...)` values; master password from the environment | [README](config-jasypt/README.md) |
| `config-server` | Spring Cloud Config Server (native backend) | [README](config-server/README.md) |
| `config-client` | Config client with optional server + local fallback | [README](config-client/README.md) |
| `config-vault` | Spring Cloud Vault + docker-compose Vault `-dev` | [README](config-vault/README.md) |
| `config-aws-parameter-store` | SSM paths via Spring Cloud AWS (LocalStack optional) | [README](config-aws-parameter-store/README.md) |
| `config-kubernetes` | ConfigMap/Secret manifests bound as env vars | [README](config-kubernetes/README.md) |

## Prerequisites

- **Java 21+**
- **Maven Wrapper** (`./mvnw`) — no global Maven install required
- **Docker** (optional) for `config-vault` and `config-aws-parameter-store` LocalStack
- **kubectl** (optional) for `config-kubernetes` manifests

## How To Run

```bash
# Build and test everything
./mvnw -B verify

# Run one module (example)
./mvnw -pl config-yaml spring-boot:run
```

Module READMEs list ports, profiles, and optional Docker steps.

## Project Layout

```text
spring-config-learning/
├── pom.xml
├── README.md
├── .github/workflows/ci.yml
├── config-yaml/
├── config-profiles/
├── ...
└── config-kubernetes/
```

## Security Notes

- Real `.env` files are gitignored; commit only `.env.example`
- Vault compose uses `root-token-for-dev-only` (dev mode learning placeholder)
- AWS examples use `changeme` / environment variables — never paste real cloud keys
- CI runs `gitleaks` on the working tree before `./mvnw -B verify`
