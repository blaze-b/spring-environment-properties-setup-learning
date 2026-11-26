# Chapter 6: Spring Cloud Config Server

[Previous: Chapter 5 — Jasypt](../chapter-05-jasypt/README.md) · [Next: Chapter 7 — Config Client](../chapter-07-config-client/README.md)

Centralise configuration in a Config Server using the **native** (classpath) backend for learning.

## What You Will Learn

- Enabling `@EnableConfigServer`
- Serving `{application}-{profile}.yml` from `classpath:/config-repo`
- The HTTP API shape clients call (`/{name}/{profile}`)

## How To Run

```bash
./mvnw -pl chapter-06-config-server spring-boot:run
curl http://localhost:8888/config-client/default
curl http://localhost:8888/config-client/dev
```

## Things To Try

1. Add `config-client-prod.yml` and request `/config-client/prod`
2. Point `search-locations` at a local Git repo for a closer-to-prod setup
3. Start Chapter 7 while this server is running
