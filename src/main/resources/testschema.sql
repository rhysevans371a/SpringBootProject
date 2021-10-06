DROP TABLE IF EXISTS product CASCADE
CREATE TABLE IF NOT EXISTS product (
  productid BIGINT NOT NULL AUTO_INCREMENT,
  aisle_name VARCHAR(255) NULL DEFAULT NULL,
  product_name VARCHAR(255) NULL DEFAULT NULL,
  unit_price DOUBLE NOT NULL,
  unit_size VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (productid)
);