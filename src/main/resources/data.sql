DROP TABLE IF EXISTS accounts;
DROP TABLE IF EXISTS delivery;
DROP TABLE IF EXISTS delivery_log;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS coupon;

CREATE TABLE accounts (
    id bigint auto_increment primary key,
    email varchar(255) unique not null,
    password varchar(255) not null,
    password_expiration_date timestamp,
    password_failed_count INT NOT NULL,
    password_ttl BIGINT,
    city varchar(255) not null,
    region varchar(255) not null,
    zip varchar(255) not null,
    created_at timestamp,
    modified_at timestamp
);

CREATE TABLE coupons (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    discount_amount DOUBLE NOT NULL,
    active BOOLEAN NOT NULL,
    created_at timestamp,
    modified_at timestamp
);

CREATE TABLE orders (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    price DOUBLE NOT NULL,
    coupon_id BIGINT,
    created_at timestamp,
    modified_at timestamp,
    FOREIGN KEY (coupon_id) REFERENCES coupons(id)
);

CREATE TABLE delivery (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    city varchar(255) not null,
    region varchar(255) not null,
    zip varchar(255) not null,
    created_at timestamp,
    modified_at timestamp
);

CREATE TABLE delivery_log (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    status VARCHAR(255) NOT NULL,
    delivery_id BIGINT NOT NULL,
    created_at timestamp,
    modified_at timestamp,
    FOREIGN KEY (delivery_id) REFERENCES delivery(id)
);
