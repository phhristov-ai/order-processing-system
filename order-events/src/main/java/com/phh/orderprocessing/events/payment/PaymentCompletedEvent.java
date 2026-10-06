package com.phh.orderprocessing.events.payment;

import java.math.BigDecimal;
import java.util.UUID;

public record PaymentCompletedEvent(
		UUID orderId,
		BigDecimal amount
) {
}