#!/bin/bash
set -e

psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" <<-EOSQL
    CREATE DATABASE messagedb;
    GRANT ALL PRIVILEGES ON DATABASE messagedb TO dbuser;
EOSQL