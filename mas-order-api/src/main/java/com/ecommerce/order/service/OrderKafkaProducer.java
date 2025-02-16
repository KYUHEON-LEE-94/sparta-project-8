package com.ecommerce.order.service;

import com.ecommerce.order.dto.OrderCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderKafkaProducer {
  private final KafkaTemplate<String, OrderCreatedEvent> kafkaTemplate;

  private static final String TOPIC = "order-created";

  public void sendOrderCreatedEvent(OrderCreatedEvent event) {
    kafkaTemplate.send(TOPIC, event);
  }
}
