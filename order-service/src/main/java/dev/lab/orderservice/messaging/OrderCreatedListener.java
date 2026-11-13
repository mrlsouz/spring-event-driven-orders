package dev.lab.orderservice.messaging;

import dev.lab.orderservice.config.RabbitConfig;
import dev.lab.orderservice.event.OrderCreatedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class OrderCreatedListener {

    private static final Logger log = LoggerFactory.getLogger(OrderEventPublisher.class);

    @RabbitListener(queues = RabbitConfig.ORDER_QUEUE)
    public void handle(OrderCreatedEvent event) {
        log.info("Pedido criado recebido: {}", event);
    }

}
