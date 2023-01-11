package com.polus.orderservice.service;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.polus.orderservice.entity.Order;
import com.polus.orderservice.external.ProductService;
import com.polus.orderservice.model.OrderRequest;
import com.polus.orderservice.repository.OrderRepository;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	OrderRepository orderRepository;
	
    private String productServiceUrl = "http://PRODUCT-SERVICE/product/";
    
    @Autowired
    ProductService productService;
    
    @Autowired
    RestTemplate restTemplate;

	@Override
	public long placeOrder(OrderRequest orderRequest) {

        log.info("Placing Order Request: {}", orderRequest);

        productService.reduceQuantity(orderRequest.getProductId(), orderRequest.getQuantity());

       // restTemplate.put(productServiceUrl+orderRequest.getProductId()+"?quantity="+orderRequest.getQuantity(), Void.class );
       
        
        log.info("Creating Order with Status CREATED");
        Order order = Order.builder()
                .price(orderRequest.getPrice())
                .orderStatus("CREATED")
                .productId(orderRequest.getProductId())
                .orderDate(Instant.now())
                .quantity(orderRequest.getQuantity())
                .paymentMode(orderRequest.getPaymentMode())
                .build();

        order = orderRepository.save(order);
        log.info("Order Places successfully with Order Id: {}", order.getOrderId());
        return order.getOrderId();
	}

}
