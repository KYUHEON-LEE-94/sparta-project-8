CREATE TABLE products (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          name VARCHAR(255) NOT NULL,
                          price DECIMAL(15, 2) NOT NULL,
                          stock int(255) NOT NULL,
                          category_id VARCHAR(15),
                          description VARCHAR(2048),
);

CREATE INDEX idx_products_name_category ON products(name, category_id);

