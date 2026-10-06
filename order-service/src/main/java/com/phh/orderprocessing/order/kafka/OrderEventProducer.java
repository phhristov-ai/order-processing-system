package com.phh.orderprocessing.order.kafka;

import com.phh.orderprocessing.events.order.OrderCreatedEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class OrderEventProducer {

	private static final String TOPIC = "orders.created";

	private final KafkaTemplate<String, Object> kafkaTemplate;

	public OrderEventProducer(
			KafkaTemplate<String, Object> kafkaTemplate
	) {
		this.kafkaTemplate = kafkaTemplate;
	}

	public void sendOrderCreated(OrderCreatedEvent event) {

		kafkaTemplate.send(
				TOPIC,
				event.orderId().toString(),
				event
		);
	}
}