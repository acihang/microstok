package com.cihanalidev.microstockproduct.repository.interfaces;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.cihanalidev.microstockproduct.model.Inventory;

public interface InventoryRepository extends MongoRepository<Inventory, Long> {
	
	@Query("{'productId' : ?0}")
	public Optional<Inventory> findByProductId(Long productId);
	
	
}
