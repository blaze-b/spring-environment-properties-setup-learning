# Spring Properties Setup Learning

Hands-on chapters for Spring Boot **properties**, **profiles**, **externalised config**, and **secrets** (Jasypt, Spring Cloud Config, Vault, AWS Parameter Store, Kubernetes). Each module is a small runnable app with tests.

[![CI](https://github.com/blaze-b/spring-properties-setup-learning/actions/workflows/ci.yml/badge.svg)](https://github.com/blaze-b/spring-properties-setup-learning/actions/workflows/ci.yml)

## Intro (basics)

Spring Boot resolves configuration from many property sources. Later sources override earlier ones. A practical mental model for this repo:

1. Packaged `application.yml` / `.properties` (defaults)
2. Profile-specific files (`application-{profile}.yml`)
3. Imported sources (`spring.config.import`, Config Server, Vault, SSM)
4. OS environment variables and JVM system properties
5. Command-line arguments (highest common precedence for local overrides)

**Relaxed binding** maps `my.property-name`, `MY_PROPERTY_NAME`, and `my.propertyName` to the same Java field. Prefer `@ConfigurationProperties` for grouped, validated config over scattered `@Value` injections.

Never commit real secrets. This repo uses obvious placeholders (`changeme`, documented Vault **dev** tokens only).

## Chapters

| Chapter | Title | Module | Summary |
| --- | --- | --- | --- |
| 1 | [Properties vs YAML](chapter-01-properties-yaml/README.md) | `chapter-01-properties-yaml` | YAML nesting, `.properties` equivalents, relaxed binding |
| 2 | [Profiles](chapter-02-profiles/README.md) | `chapter-02-profiles` | `local` / `dev` / `prod` files and env placeholders |
| 3 | [Configuration Properties](chapter-03-configuration-properties/README.md) | `chapter-03-configuration-properties` | `@ConfigurationProperties` + Bean Validation |
| 4 | [Externalised Config](chapter-04-externalized-config/README.md) | `chapter-04-externalized-config` | Env vars, CLI, `config.import`, `.env.example` |
| 5 | [Jasypt](chapter-05-jasypt/README.md) | `chapter-05-jasypt` | `ENC(...)` values; master password from the environment |
| 6 | [Config Server](chapter-06-config-server/README.md) | `chapter-06-config-server` | Spring Cloud Config Server (native backend) |
| 7 | [Config Client](chapter-07-config-client/README.md) | `chapter-07-config-client` | Config client with optional server + local fallback |
| 8 | [HashiCorp Vault](chapter-08-vault/README.md) | `chapter-08-vault` | Spring Cloud Vault + docker-compose Vault `-dev` |
| 9 | [AWS Parameter Store](chapter-09-aws-parameter-store/README.md) | `chapter-09-aws-parameter-store` | SSM paths via Spring Cloud AWS (LocalStack optional) |
| 10 | [Kubernetes ConfigMaps & Secrets](chapter-10-kubernetes/README.md) | `chapter-10-kubernetes` | ConfigMap/Secret manifests bound as env vars |

## Prerequisites

- **Java 21+**
- **Maven Wrapper** (`./mvnw`) — no global Maven install required
- **Docker** (optional) for Chapter 8 Vault and Chapter 9 LocalStack
- **kubectl** (optional) for Chapter 10 manifests

## How To Run

```bash
# Build and test everything
./mvnw -B verify

# Run one chapter (example)
./mvnw -pl chapter-01-properties-yaml spring-boot:run
```

Chapter READMEs list ports, profiles, and optional Docker steps.

## Project Layout

```text
spring-properties-setup-learning/
├── pom.xml
├── README.md
├── .github/workflows/ci.yml
├── chapter-01-properties-yaml/
├── chapter-02-profiles/
├── ...
└── chapter-10-kubernetes/
```

## Security Notes

- Real `.env` files are gitignored; commit only `.env.example`
- Vault compose uses `root-token-for-dev-only` (dev mode learning placeholder)
- AWS examples use `changeme` / environment variables — never paste real cloud keys
- CI runs `gitleaks` on the working tree before `./mvnw -B verify`
