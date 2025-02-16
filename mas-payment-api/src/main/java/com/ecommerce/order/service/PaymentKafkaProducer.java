package com.ecommerce.order.service;

import com.ecommerce.order.dto.PaymentEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class PaymentKafkaProducer {

  private final KafkaTemplate<String, PaymentEvent> kafkaTemplate;

  public void sendPaymentEvent(PaymentEvent event) {
    kafkaTemplate.send("payment-result", event);
    log.info("Kafka Payment Event Sent: {}", event);
  }
}
