DROP TABLE hotel IF EXISTS;

CREATE TABLE hotel  (
    id VARCHAR(20) IDENTITY NOT NULL PRIMARY KEY,
    address VARCHAR(250),
    city VARCHAR(20),
    country VARCHAR(20),
    name VARCHAR(20)
);