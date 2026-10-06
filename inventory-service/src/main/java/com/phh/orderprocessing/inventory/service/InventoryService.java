package com.phh.orderprocessing.inventory.service;

import com.phh.orderprocessing.events.inventory.InventoryFailedEvent;
import com.phh.orderprocessing.events.inventory.InventoryReservedEvent;
import com.phh.orderprocessing.events.order.OrderCreatedEvent;
import com.phh.orderprocessing.inventory.kafka.producer.InventoryEventProducer;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class InventoryService {

	private final InventoryEventProducer producer;


	public InventoryService(
			InventoryEventProducer producer
	) {
		this.producer = producer;
	}


	public void reserve(OrderCreatedEvent event) {

		System.out.println(
				"Checking inventory for order " + event.orderId()
		);

		boolean reserved = checkInventory(event);


		if (reserved) {

			producer.sendInventoryReserved(
					new InventoryReservedEvent(
							event.orderId(),
							Instant.now()
					)
			);

		} else {

			producer.sendInventoryReservationFailed(
					new InventoryFailedEvent(
							event.orderId(),
							"Product out of stock",
							Instant.now()
					)
			);
		}
	}


	private boolean checkInventory(OrderCreatedEvent event) {
		return true;
	}
}