package com.cihanalidev.microstokpayment.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.cihanalidev.microstokproduct.model.Product;

@Service
public class PaymentService {

	
	 @KafkaListener(topics = "${user.topic.name}", 
	            groupId = "${user.topic.group.id}",
	            containerFactory = "userKafkaListenerContainerFactory")
	    public void consume(Product user) {
	    }
	
}
