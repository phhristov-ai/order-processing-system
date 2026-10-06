package com.phh.orderprocessing.events.payment;

public record PaymentFailedEvent(
		Long orderId,
		String reason
) {
}