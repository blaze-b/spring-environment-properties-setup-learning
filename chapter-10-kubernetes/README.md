# Chapter 10: Kubernetes ConfigMaps and Secrets

[Previous: Chapter 9 — AWS Parameter Store](../chapter-09-aws-parameter-store/README.md) · [Next: Root overview](../README.md)

Ship non-secret config via ConfigMaps and sensitive values via Secrets, consumed as environment variables by Spring Boot.

## What You Will Learn

- Separating ConfigMap data from Secret `stringData`
- Wiring both with `envFrom` on a Deployment
- Binding `WORKLOAD_*` env vars with relaxed binding

## How To Run Locally

```bash
WORKLOAD_ENVIRONMENT_NAME=staging \
WORKLOAD_DB_URL=jdbc:postgresql://localhost:5432/config_learning \
WORKLOAD_DB_PASSWORD=changeme \
  ./mvnw -pl chapter-10-kubernetes spring-boot:run

curl http://localhost:8090/workload
```

### Apply Manifests (cluster optional)

```bash
kubectl apply -f chapter-10-kubernetes/k8s/
```

## Things To Try

1. Change the ConfigMap and restart the Pod — confirm `/workload` updates
2. Mount the Secret as a file volume instead of env vars
3. Compare this approach with Vault Agent / External Secrets Operator
