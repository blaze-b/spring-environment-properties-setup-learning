# Chapter 4: Externalised Config

[Previous: Chapter 3 — Configuration Properties](../chapter-03-configuration-properties/README.md) · [Next: Chapter 5 — Jasypt](../chapter-05-jasypt/README.md)

Push configuration outside the JAR: environment variables, command-line args, `spring.config.import`, and optional `.env` files.

## What You Will Learn

- Property source precedence (CLI > env > imported files > application.yml)
- `spring.config.import=optional:file|classpath:...`
- Using `.env.example` safely (real `.env` is gitignored)

## Key Concepts

| Source | Example |
| --- | --- |
| Env var | `APP_SERVICE_API_KEY=changeme` |
| CLI | `--app.service.name=cli-demo` |
| Import | `spring.config.import=optional:classpath:extra-config.properties` |
| Dotenv | `spring-dotenv` loads `.env` when present |

## How To Run

```bash
./mvnw -pl chapter-04-externalized-config spring-boot:run
curl http://localhost:8084/config

APP_SERVICE_API_KEY=changeme ./mvnw -pl chapter-04-externalized-config spring-boot:run \
  -Dspring-boot.run.arguments=--app.service.name=cli-demo
```

Copy [`.env.example`](.env.example) to `.env` if you want dotenv-style local overrides.

## Things To Try

1. Import a file outside the repo with `optional:file:./local-overrides.properties`
2. Confirm CLI args beat env vars for the same key
3. Intentionally omit `optional:` on an import and observe startup failure when the file is missing
