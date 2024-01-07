create database inventory;

CREATE TABLE inventory (
  inventory_id        VARCHAR(100) PRIMARY KEY NOT NULL,
  inventory_name      TEXT NOT NULL,
  quantity            INT NOT NULL,
  price               NUMERIC(5,2),
  comment           VARCHAR(100));

INSERT into inventory VALUES ('f3831f8c-c338-4ebe-a82a-e2fc1d1ff78a','samsung s23',300,203.34,'good phone');