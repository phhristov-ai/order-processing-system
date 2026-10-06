package com.phh.orderprocessing.events.order;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

public record OrderCreatedEvent(
		UUID orderId,
		UUID customerId,
		List<OrderItem> items,
		BigDecimal totalAmount,
		Instant createdAt
) {
}