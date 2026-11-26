# Spring Cloud Config Server

[Previous: `config-jasypt`](../config-jasypt/README.md) · [Next: `config-client`](../config-client/README.md)

Centralise configuration in a Config Server using the **native** (classpath) backend for learning.

## What You Will Learn

- Enabling `@EnableConfigServer`
- Serving `{application}-{profile}.yml` from `classpath:/config-repo`
- The HTTP API shape clients call (`/{name}/{profile}`)

## How To Run

```bash
./mvnw -pl config-server spring-boot:run
curl http://localhost:8888/config-client/default
curl http://localhost:8888/config-client/dev
```

## Things To Try

1. Add `config-client-prod.yml` and request `/config-client/prod`
2. Point `search-locations` at a local Git repo for a closer-to-prod setup
3. Start `config-client` while this server is running
