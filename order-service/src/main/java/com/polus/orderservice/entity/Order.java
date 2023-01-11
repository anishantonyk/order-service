package com.polus.orderservice.entity;

import java.time.Instant;

import com.polus.orderservice.model.PaymentMode;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "_ORDER")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	private long orderId;
	
	@Column(name = "product_id")
	private long productId;
	
	@Column(name = "orderStatus")
	private String orderStatus;
	
	@Column(name = "quantity")
	private long quantity;
	
	@Column(name = "price")
	private double price;
	
	@Column(name = "order_date")
	private Instant orderDate;
	
	@Column(name = "payment_mode")
	private PaymentMode paymentMode;
	

}
