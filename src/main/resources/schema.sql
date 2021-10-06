DROP TABLE IF EXISTS product;
CREATE TABLE IF NOT EXISTS product (
  productid BIGINT NOT NULL AUTO_INCREMENT,
  product_name VARCHAR(255) NULL DEFAULT NULL,
  aisle_name VARCHAR(255) NULL DEFAULT NULL,
  unit_size VARCHAR(255) NULL DEFAULT NULL,
  unit_price DOUBLE NOT NULL,
  PRIMARY KEY (productid)
);