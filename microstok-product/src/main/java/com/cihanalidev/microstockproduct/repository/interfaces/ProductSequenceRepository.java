package com.cihanalidev.microstockproduct.repository.interfaces;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cihanalidev.microstockproduct.model.ProductSequence;

@Repository
public interface ProductSequenceRepository extends MongoRepository<ProductSequence, String>,ProductSequenceRepositoryCustom{
	
	
}
