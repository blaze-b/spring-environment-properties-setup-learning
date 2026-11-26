# Profiles

[Previous: `config-yaml`](../config-yaml/README.md) · [Next: `config-configuration-properties`](../config-configuration-properties/README.md)

Use Spring profiles and per-environment files (`application-{profile}.yml`) to switch configuration safely.

## What You Will Learn

- How `spring.profiles.active` / `SPRING_PROFILES_ACTIVE` selects files
- How profile-specific files override defaults without duplication
- How env-var placeholders fit into `dev` / `prod` files

## Key Concepts

| Idea | Detail |
| --- | --- |
| Default profile | `spring.profiles.default=local` for laptop-friendly defaults |
| File naming | `application-dev.yml` activates with profile `dev` |
| Placeholders | `${DB_HOSTNAME:localhost}` keeps secrets out of git |

## How It Works

Shared keys live in `application.yml`. Profile files only override what changes:

- `application-local.yml` — in-memory style URLs for learning
- `application-dev.yml` — Postgres with safe defaults
- `application-prod.yml` — Postgres requiring real env vars

`GET /environment` shows the active profiles and resolved values.

## How To Run

```bash
./mvnw -pl config-profiles spring-boot:run
curl http://localhost:8082/environment

SPRING_PROFILES_ACTIVE=dev ./mvnw -pl config-profiles spring-boot:run
```

## Things To Try

1. Switch to `prod` without setting `DB_HOSTNAME` and observe the unresolved placeholder behavior
2. Activate two profiles: `SPRING_PROFILES_ACTIVE=local,dev` and see which file wins for a shared key
3. Move a key only into `application-prod.yml` and confirm other profiles keep the default
