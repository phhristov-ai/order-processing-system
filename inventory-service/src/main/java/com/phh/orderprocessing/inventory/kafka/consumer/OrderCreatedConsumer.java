package com.phh.orderprocessing.inventory.kafka.consumer;

import com.phh.orderprocessing.events.order.OrderCreatedEvent;
import com.phh.orderprocessing.inventory.service.InventoryService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class OrderCreatedConsumer {

	private final InventoryService inventoryService;

	public OrderCreatedConsumer(
			InventoryService inventoryService
	) {
		this.inventoryService = inventoryService;
	}


	@KafkaListener(
			topics = "orders.created",
			groupId = "inventory-service"
	)
	public void consume(OrderCreatedEvent event) {

		inventoryService.reserve(event);
	}
}