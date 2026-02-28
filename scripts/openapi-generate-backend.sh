#!/usr/bin/env bash
set -euo pipefail

SPEC="packages/openapi/spec/timebox-planner.openapi.yaml"
OUT="packages/openapi/generated/backend"

openapi-generator-cli generate \
  -i "$SPEC" \
  -g spring \
  -o "$OUT" \
  --additional-properties=interfaceOnly=true,useSpringBoot3=true,delegatePattern=true

echo "Generated backend stub at $OUT"
