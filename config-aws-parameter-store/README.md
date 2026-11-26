# AWS Parameter Store

[Previous: `config-vault`](../config-vault/README.md) · [Next: `config-kubernetes`](../config-kubernetes/README.md)

Load configuration from **AWS Systems Manager Parameter Store** using Spring Cloud AWS 3 (`io.awspring.cloud`). No real AWS keys are committed.

## What You Will Learn

- Path convention `/config/{application}/...`
- Enabling Parameter Store via `spring.config.import=aws-parameterstore:...`
- Using LocalStack optionally for offline practice

## Key Concepts

| Idea | Detail |
| --- | --- |
| Path layout | `/config/{app}/...` parameters map into the Spring `Environment` |
| Credentials | Env vars or the default AWS provider chain — never commit keys |
| Offline CI | AWS autoconfig is excluded by default so tests run without cloud access |

## How To Run

```bash
./mvnw -pl config-aws-parameter-store spring-boot:run
curl http://localhost:8089/params
```

### Against LocalStack (optional)

```bash
cd config-aws-parameter-store && docker compose up -d
# Create parameters with awslocal / aws --endpoint-url=http://localhost:4566
SPRING_PROFILES_ACTIVE=aws AWS_ACCESS_KEY_ID=test AWS_SECRET_ACCESS_KEY=test \
  ./mvnw -pl config-aws-parameter-store spring-boot:run
```

## Things To Try

1. Create `/config/config-aws-parameter-store/demo.aws.greeting` in SSM and reload with the `aws` profile
2. Compare Vault KV (`config-vault`) vs SSM paths for the same logical secret
3. Switch credentials from static env vars to the default provider chain
