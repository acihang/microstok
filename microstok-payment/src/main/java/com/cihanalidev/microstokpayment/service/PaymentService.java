package com.cihanalidev.microstokpayment.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.cihanalidev.microstockproduct.model.Product;


@Service
public class PaymentService {

	@KafkaListener(topics = "buyProduct", groupId = "microstok")
	public void consume(Product product) {
		System.out.println("kafka product user id:" + product.getProductId() + " name:" + product.getName());
	}

}
