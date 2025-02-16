CREATE TABLE payment (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          orderId VARCHAR(255) NOT NULL,
                          status VARCHAR(15),
);

