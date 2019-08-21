#!/bin/bash
set -e

psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" <<-EOSQL
    CREATE DATABASE messagedb;
    GRANT ALL PRIVILEGES ON DATABASE messagedb TO dbuser;
    \l
    \c messagedb
    CREATE TABLE message(
       id serial PRIMARY KEY,
       data VARCHAR (50) UNIQUE NOT NULL
    );

    INSERT INTO message VALUES (1, 'Hello World 2');
EOSQL

