package com.cihanalidev.microstockproduct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.cihanalidev.microstockproduct.repository")
public class MicrostockProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicrostockProductApplication.class, args);
	}
	

}
