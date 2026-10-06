package com.phh.orderprocessing.order.controller;


import com.phh.orderprocessing.order.domain.Order;
import com.phh.orderprocessing.order.dto.CreateOrderRequest;
import com.phh.orderprocessing.order.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {


	private final OrderService service;


	public OrderController(OrderService service) {
		this.service = service;
	}


	@PostMapping
	public ResponseEntity<Order> create(
			@RequestBody CreateOrderRequest request
	) {

		return ResponseEntity.ok(
				service.createOrder(request)
		);
	}
}