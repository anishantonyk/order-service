package com.polus.orderservice.model;

import lombok.Data;

@Data
public class OrderRequest {
		
	private long productId;
	
	private long quantity;
	
	private double price;
	
	private PaymentMode paymentMode;
	
	}
