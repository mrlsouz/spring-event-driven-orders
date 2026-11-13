package dev.lab.orderservice.event;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public record OrderCreatedEvent(UUID orderId, String customerId, BigDecimal total, Instant createdAt) {
}
