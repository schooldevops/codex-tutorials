#!/usr/bin/env bash
set -euo pipefail

SPEC="packages/openapi/spec/timebox-planner.openapi.yaml"
OUT="packages/openapi/generated/frontend"

openapi-generator-cli generate \
  -i "$SPEC" \
  -g typescript-axios \
  -o "$OUT" \
  --additional-properties=withInterfaces=true,typescriptThreePlus=true,modelPropertyNaming=original

echo "Generated frontend client at $OUT"
