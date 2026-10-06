package com.phh.orderprocessing.order.service;

import com.phh.orderprocessing.events.order.OrderCreatedEvent;
import com.phh.orderprocessing.events.order.OrderItem;
import com.phh.orderprocessing.order.domain.Order;
import com.phh.orderprocessing.order.dto.CreateOrderRequest;
import com.phh.orderprocessing.order.kafka.OrderEventProducer;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
public class OrderService {


	private final OrderEventProducer producer;

	public OrderService(OrderEventProducer producer) {
		this.producer = producer;
	}


	public Order createOrder(CreateOrderRequest request) {

		UUID orderId = UUID.randomUUID();

		Order order = new Order(
				orderId,
				request.customerId(),
				request.items()
						.stream()
						.map(i -> new OrderItem(
								i.productId(),
								i.quantity()
						))
						.toList(),
				request.totalAmount()
		);


		OrderCreatedEvent event =
				new OrderCreatedEvent(
						order.id(),
						order.customerId(),
						request.items()
								.stream()
								.map(i -> new OrderItem(
										i.productId(),
										i.quantity()
								))
								.toList(),
						order.totalAmount(),
						Instant.now()
				);


		producer.sendOrderCreated(event);

		return order;
	}
}