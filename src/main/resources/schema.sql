DROP SCHEMA IF EXISTS retail CASCADE;
CREATE SCHEMA retail;

CREATE TABLE IF NOT EXISTS retail.user (
  user_uuid UUID PRIMARY KEY,
  "name" VARCHAR(50) DEFAULT NULL,
   credit_card VARCHAR(50) DEFAULT null
);

CREATE TABLE IF NOT EXISTS retail.order (
  order_uuid UUID PRIMARY KEY,
  user_uuid UUID,
  FOREIGN KEY (user_uuid) REFERENCES retail.user (user_uuid)
);

CREATE TABLE IF NOT EXISTS retail.product (
  product_uuid UUID PRIMARY KEY,
  "name" VARCHAR(50)
);

CREATE SEQUENCE retail.order_product_seq START 1;
CREATE TABLE IF NOT EXISTS retail.order_product (
  order_product NUMERIC(10, 0) PRIMARY KEY DEFAULT nextval('retail.order_product_seq'),
  product_uuid UUID,
  order_uuid UUID,
  FOREIGN KEY (product_uuid) REFERENCES retail.product (product_uuid),
  FOREIGN KEY (order_uuid) REFERENCES retail.order (order_uuid)
);
