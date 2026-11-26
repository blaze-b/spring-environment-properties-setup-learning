# Properties vs YAML

[Previous: Root overview](../README.md) · [Next: `config-profiles`](../config-profiles/README.md)

Learn how Spring Boot loads `application.properties` and `application.yml`, and how **relaxed binding** maps config keys to Java types.

## What You Will Learn

- When to prefer YAML nesting vs flat `.properties` keys
- How kebab-case YAML maps to camelCase Java fields
- How env vars like `APP_INFO_MAX_RETRIES` bind to the same property

## Key Concepts

| Idea | Detail |
| --- | --- |
| Property sources | `application.yml` / `.properties` on the classpath are default sources |
| Relaxed binding | `display-name`, `display_name`, `DISPLAY_NAME` all map to `displayName` |
| Records | `@ConfigurationProperties` works with immutable Java records |

## How It Works

`AppInfoProperties` is scanned via `@ConfigurationPropertiesScan` and bound from:

```yaml
app:
  info:
    display-name: Properties vs YAML Demo
    owner-email: learner@example.com
    max-retries: 3
```

`GET /info` returns the bound values so you can experiment live.

An equivalent flat file lives at [`application-properties-style.properties`](src/main/resources/application-properties-style.properties) for side-by-side comparison.

## How To Run

```bash
./mvnw -pl config-yaml spring-boot:run
curl http://localhost:8081/info
```

## Things To Try

1. Override with an env var: `APP_INFO_MAX_RETRIES=9 ./mvnw -pl config-yaml spring-boot:run`
2. Pass a CLI arg: `./mvnw -pl config-yaml spring-boot:run -Dspring-boot.run.arguments=--app.info.display-name=CLI`
3. Copy keys from the `.properties` sample into `application.properties` and delete the YAML — confirm `/info` is unchanged
