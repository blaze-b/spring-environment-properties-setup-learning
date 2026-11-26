# Chapter 9: AWS Parameter Store

[Previous: Chapter 8 — Vault](../chapter-08-vault/README.md) · [Next: Chapter 10 — Kubernetes](../chapter-10-kubernetes/README.md)

Load configuration from **AWS Systems Manager Parameter Store** (the non-Vault half of Brian’s `lymbyc` / AWS secrets training repos).

## Sources Covered Here (distinct from Vault)

| Former repo | What we kept |
| --- | --- |
| `lymbyc-secret-config-connector` | AWS SSM path prefix + recursive parameter loading concepts |
| `aws-secrets-boot-training` | `/config/{app}` path layout, region, credentials-from-env |
| `secrets-management-service` (`lymbyc-secret-spring-app`, AWS factory) | Selecting a property source (`vault` vs `aws-param-store`) — here as separate chapters 8 vs 9 |

Rewritten on **Spring Cloud AWS 3** (`io.awspring.cloud`) for Boot 3. No real AWS keys are committed.

## What You Will Learn

- Path convention `/config/{application}/...`
- Enabling Parameter Store via `spring.config.import=aws-parameterstore:...`
- Using LocalStack optionally for offline practice

## How To Run

```bash
./mvnw -pl chapter-09-aws-parameter-store spring-boot:run
curl http://localhost:8089/params
```

### Against LocalStack (optional)

```bash
cd chapter-09-aws-parameter-store && docker compose up -d
# Create parameters with awslocal / aws --endpoint-url=http://localhost:4566
SPRING_PROFILES_ACTIVE=aws AWS_ACCESS_KEY_ID=test AWS_SECRET_ACCESS_KEY=test \
  ./mvnw -pl chapter-09-aws-parameter-store spring-boot:run
```

## Things To Try

1. Create `/config/chapter-09-aws-parameter-store/demo.aws.greeting` in SSM and reload with the `aws` profile
2. Compare Vault KV (Chapter 8) vs SSM paths for the same logical secret
3. Switch credentials from static env vars to the default provider chain
