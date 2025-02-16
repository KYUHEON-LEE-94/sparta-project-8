package com.ecommerce.order.model;

import lombok.AccessLevel;
import lombok.Data;
import javax.persistence.*;
import lombok.experimental.FieldDefaults;

@Data
@Entity
@Table(name = "orders")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long userId;
    Long productId;
    Integer quantity;
}
