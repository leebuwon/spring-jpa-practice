DROP TABLE IF EXISTS accounts;

CREATE TABLE accounts (
    id bigint auto_increment primary key,
    email varchar(255) unique not null,
    password varchar(255) not null,
    city varchar(255) not null,
    region varchar(255) not null,
    zip varchar(255) not null,
    created_at timestamp,
    modified_at timestamp
);