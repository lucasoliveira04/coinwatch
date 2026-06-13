CREATE TABLE user_entity (
    id BIGSERIAL PRIMARY KEY,
    guid VARCHAR(36) UNIQUE NOT NULL,
    name VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL,
    password VARCHAR(100) NOT NULL,
    creation_date TIMESTAMP,
    update_date TIMESTAMP
);