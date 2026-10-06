package com.phh.orderprocessing.events.order;

import java.util.UUID;

public record OrderItem(
		UUID productId,
		Integer quantity
) {
}