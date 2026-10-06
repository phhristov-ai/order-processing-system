package com.phh.orderprocessing.events.inventory;

import java.time.Instant;
import java.util.UUID;

public record InventoryReservedEvent(
		UUID orderId,
		Instant reservedAt
) {
}