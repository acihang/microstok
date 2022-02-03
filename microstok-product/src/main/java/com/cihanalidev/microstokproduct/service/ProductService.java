package com.cihanalidev.microstokproduct.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.cihanalidev.microstokproduct.model.Product;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ProductService {

	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;
	private static final String TOPIC = "product";
	
	public void buyProduct(Product product) {
		try {
			String json = new ObjectMapper().writeValueAsString(product);
			kafkaTemplate.send(TOPIC, product.getId(), json);
			System.out.println("Message Send");
		} catch (JsonProcessingException e) {
			System.out.println("error when sending message" + e.getMessage());
		}
	}
	

}
