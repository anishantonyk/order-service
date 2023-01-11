package com.polus.orderservice.model;

import java.time.Instant;

import lombok.Data;

@Data
public class OrderResponse {

	private long orderId;
	
	private long productId;
	
	private String orderStatus;
	
	private long quantity;
	
	private double price;
	
	private Instant orderDate;
	
	private PaymentMode paymentMode;
}
