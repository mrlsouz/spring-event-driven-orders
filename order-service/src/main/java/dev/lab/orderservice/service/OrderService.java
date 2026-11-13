package dev.lab.orderservice.service;

import dev.lab.orderservice.dto.CreateOrderRequest;

import dev.lab.orderservice.event.OrderCreatedEvent;
import dev.lab.orderservice.messaging.OrderEventPublisher;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
public class OrderService {

    private final OrderEventPublisher publisher;

    public OrderService(OrderEventPublisher publisher) {
        this.publisher = publisher;
    }

    public UUID createOrder(CreateOrderRequest request) {
        UUID orderId = UUID.randomUUID();

        OrderCreatedEvent event;
        event = new OrderCreatedEvent(
                orderId,
                request.customerId(),
                request.total(),
                Instant.now()
        );

        publisher.publish(event);
        return orderId;
    }

}
