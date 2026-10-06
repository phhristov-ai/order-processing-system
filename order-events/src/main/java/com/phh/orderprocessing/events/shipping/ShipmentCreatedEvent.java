package com.phh.orderprocessing.events.shipping;

import java.time.Instant;
import java.util.UUID;

public record ShipmentCreatedEvent(
		UUID orderId,
		String trackingNumber,
		Instant createdAt
) {
}