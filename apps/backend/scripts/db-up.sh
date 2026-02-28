#!/usr/bin/env bash
set -euo pipefail

cd "$(dirname "$0")/.."
docker compose up -d postgres

echo "PostgreSQL is starting."
echo "Check health: docker compose ps"
