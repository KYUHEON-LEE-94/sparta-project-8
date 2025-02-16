package com.ecommerce.order.service;

import com.ecommerce.order.dto.OrderCreatedEvent;
import com.ecommerce.order.dto.PaymentEvent;
import com.ecommerce.order.model.Payment;
import com.ecommerce.order.repository.PaymentRepository;
import java.util.List;
import java.util.Random;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class PaymentService {
    private final KafkaTemplate<String, PaymentEvent> kafkaTemplate;

    private final PaymentRepository paymentRepository;

    public List<Payment> findAll(){
        return paymentRepository.findAll();
    }

    @KafkaListener(topics = "order-created", groupId = "payment-group")
    public void processPayment(OrderCreatedEvent event) {
       log.info("Received Payment Event: {}", event);

        boolean paymentSuccess = new Random().nextBoolean();

        String status = paymentSuccess ? "PAID" : "FAILED";

        PaymentEvent paymentEvent = new PaymentEvent(event.getOrderId(), status);
        kafkaTemplate.send("payment-result", paymentEvent);

        log.info("Payment Event Sent: {}", paymentEvent);
    }

}
