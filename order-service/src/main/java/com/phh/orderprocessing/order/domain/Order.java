package com.phh.orderprocessing.order.domain;

import com.phh.orderprocessing.events.order.OrderItem;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public record Order(
		UUID id,
		UUID customerId,
		List<OrderItem> items,
		BigDecimal totalAmount
) {
}