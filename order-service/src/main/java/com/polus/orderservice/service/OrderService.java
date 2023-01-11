package com.polus.orderservice.service;

import com.polus.orderservice.model.OrderRequest;

public interface OrderService {

	long placeOrder(OrderRequest orderRequest);

}
