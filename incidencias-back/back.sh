#!/bin/sh
set -eu
cd "$(dirname "$0")"
: "${DB_PASSWORD:?Set DB_PASSWORD before starting the backend}"
exec java -jar ./target/incidencias-back-1.0.0-runner.jar
