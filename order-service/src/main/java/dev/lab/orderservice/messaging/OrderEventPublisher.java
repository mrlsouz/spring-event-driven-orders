package dev.lab.orderservice.messaging;
import dev.lab.orderservice.event.OrderCreatedEvent;

public interface OrderEventPublisher {
    void publish(OrderCreatedEvent event);
}