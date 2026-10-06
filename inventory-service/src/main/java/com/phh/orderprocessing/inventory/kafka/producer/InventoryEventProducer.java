package com.phh.orderprocessing.inventory.kafka.producer;

import com.phh.orderprocessing.events.inventory.InventoryFailedEvent;
import com.phh.orderprocessing.events.inventory.InventoryReservedEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class InventoryEventProducer {

	private static final String RESERVED_TOPIC =
			"inventory.reserved";

	private static final String FAILED_TOPIC =
			"inventory.reservation.failed";

	private final KafkaTemplate<String,Object> kafkaTemplate;


	public InventoryEventProducer(
			KafkaTemplate<String,Object> kafkaTemplate
	) {
		this.kafkaTemplate = kafkaTemplate;
	}


	public void sendInventoryReserved(
			InventoryReservedEvent event
	) {

		kafkaTemplate.send(
				RESERVED_TOPIC,
				event.orderId().toString(),
				event
		);
	}

	public void sendInventoryReservationFailed(
			InventoryFailedEvent event
	) {

		kafkaTemplate.send(
				FAILED_TOPIC,
				event.orderId().toString(),
				event
		);
	}
}