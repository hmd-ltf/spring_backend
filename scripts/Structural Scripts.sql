CREATE TABLE IF NOT EXISTS b_statuses (
    id      SERIAL,
    code    VARCHAR(32) PRIMARY KEY,
    name    VARCHAR(255),
    details VARCHAR(255)
    );

CREATE TABLE IF NOT EXISTS b_roles (
    id      SERIAL,
    code    VARCHAR(32) PRIMARY KEY,
    name    VARCHAR(255),
    details VARCHAR(255)
    );

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

CREATE TABLE IF NOT EXISTS organizations_users_mappings (
    id              SERIAL PRIMARY KEY,
    user_id         INT,
    organization_id INT,

    CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES users (id),
    CONSTRAINT fk_organization_id FOREIGN KEY (organization_id) REFERENCES organizations (id)
    );

SET TIMEZONE = 'Asia/Karachi';

CREATE TABLE IF NOT EXISTS tasks (
    id             SERIAL PRIMARY KEY,
    name           VARCHAR(255) NOT NULL,
    details        TEXT,
    status         VARCHAR(32),
    estimated_time INTERVAL,
    remaining_time INTERVAL,
    deadline       TIMESTAMP,
    created_at     TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    started_at     TIMESTAMP,

    CONSTRAINT fk_status FOREIGN KEY (status) REFERENCES b_statuses (code)
    );

CREATE TABLE IF NOT EXISTS tasks_work_details (
    id       SERIAL PRIMARY KEY,
    task_id  INT,
    start_at TIMESTAMP,
    end_at   TIMESTAMP,

    CONSTRAINT fk_task_id FOREIGN KEY (task_id) REFERENCES tasks (id)
    );


CREATE TABLE IF NOT EXISTS user_tasks (
    id      SERIAL PRIMARY KEY,
    task_id INT,
    user_id INT,
    role    VARCHAR(32),

    CONSTRAINT fk_task_id FOREIGN KEY (task_id) REFERENCES tasks (id),
    CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES users (id),
    CONSTRAINT fk_roles FOREIGN KEY (role) REFERENCES b_roles (code)
    );