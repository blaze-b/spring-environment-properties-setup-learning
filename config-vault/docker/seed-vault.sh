#!/usr/bin/env bash
# Seed KV secrets and a transit key for the vault profile (dev only).
set -euo pipefail
export VAULT_ADDR="${VAULT_ADDR:-http://127.0.0.1:8200}"
export VAULT_TOKEN="${VAULT_TOKEN:-root-token-for-dev-only}"

echo "Waiting for Vault..."
until vault status >/dev/null 2>&1; do sleep 1; done

vault secrets enable -path=secret kv-v2 2>/dev/null || true
vault secrets enable transit 2>/dev/null || true
vault write -f transit/keys/vault-app-key 2>/dev/null || true

vault kv put secret/config-vault \
  demo.secrets.username=vault-user \
  demo.secrets.password=vault-password-changeme \
  demo.secrets.api-key=vault-api-key-changeme

echo "Seeded secret/config-vault and transit key vault-app-key"
