package com.ecommerce.product.model;

import lombok.AccessLevel;
import lombok.Data;
import javax.persistence.*;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@Entity
@Table(name = "products")
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String price;
    Integer stock;
    String category_id;
}
