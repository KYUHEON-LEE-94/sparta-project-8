package com.ecommerce.order.model;

import lombok.AccessLevel;
import lombok.Data;
import javax.persistence.*;
import lombok.experimental.FieldDefaults;

@Data
@Entity
@Table(name = "payment")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long orderId;
    String status;
}
