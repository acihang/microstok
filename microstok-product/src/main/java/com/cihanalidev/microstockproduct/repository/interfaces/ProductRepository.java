package com.cihanalidev.microstockproduct.repository.interfaces;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

import com.cihanalidev.microstockproduct.model.Product;

@Repository
@EnableMongoRepositories
public interface ProductRepository extends MongoRepository<Product, Long> {

	@Query("{'category' : ?0}")
	List<Product> getProductsByCategory(String category);

	@Query("{'name' : ?0}")
	Product getProductByName(String name);
	
	@Query("{'id' : ?0}")
	Product getProductById(Long productId);
}
