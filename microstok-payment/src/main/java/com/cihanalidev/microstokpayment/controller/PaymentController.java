package com.cihanalidev.microstokpayment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cihanalidev.microstokpayment.service.PaymentService;
import com.cihanalidev.microstokpayment.model.Payment;
import com.cihanalidev.microstokpayment.service.PaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentController {

//	@Autowired
//	private PaymentService productService;
//	
//	@PostMapping("/1.0/buyProduct")
//	public String buyProduct(@RequestBody Product product) {
//		productService.buyProduct(product);
//		return "Success";
//	}
}
