CREATE TABLE IF NOT EXISTS users (
    id       SERIAL PRIMARY KEY,
    username VARCHAR(255) UNIQUE NOT NULL,
    email    VARCHAR(255) UNIQUE,
    password VARCHAR(255)        NOT NULL
    );

CREATE TABLE IF NOT EXISTS organizations (
    id      SERIAL PRIMARY KEY,
    name    VARCHAR(255) UNIQUE NOT NULL,
    address TEXT UNIQUE,
    email   VARCHAR(255) UNIQUE
    );