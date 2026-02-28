#!/usr/bin/env bash
set -euo pipefail

ROOT_DIR="$(cd "$(dirname "$0")/.." && pwd)"

"$ROOT_DIR/scripts/db-up.sh"

JAVA_HOME="${JAVA_HOME:-$HOME/.sdkman/candidates/java/21.0.9-amzn}"
PATH="$JAVA_HOME/bin:$PATH"

cd "$ROOT_DIR/.."
gradle -p backend flywayMigrate
gradle -p backend generateJooq

echo "DB initialized and jOOQ generated successfully."
