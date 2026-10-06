package com.phh.orderprocessing.order.dto;

import java.util.UUID;

public record OrderItemRequest(
		UUID productId,
		Integer quantity
) {
}