# Configuration Properties

[Previous: `config-profiles`](../config-profiles/README.md) · [Next: `config-externalized`](../config-externalized/README.md)

Type-safe configuration with `@ConfigurationProperties` and Bean Validation.

## What You Will Learn

- Binding nested YAML into a dedicated properties class
- Enabling validation with `@Validated` + Jakarta constraints
- Preferring `@ConfigurationProperties` over scattered `@Value` fields

## Key Concepts

| Idea | Detail |
| --- | --- |
| Prefix | `app.mailer` groups related keys |
| Validation | Fail fast at startup when required keys are missing |
| Lists / booleans | Bind collections and flags without manual parsing |

## How It Works

`MailerProperties` is validated at context refresh. Invalid config (blank host, empty recipients, illegal port) prevents the app from starting.

## How To Run

```bash
./mvnw -pl config-configuration-properties spring-boot:run
curl http://localhost:8083/mailer
```

## Things To Try

1. Remove `app.mailer.host` and restart — confirm startup fails with a validation error
2. Set `app.mailer.port=70000` and observe `@Max` failing
3. Add a nested `credentials` object under `app.mailer` and bind it with a nested class
