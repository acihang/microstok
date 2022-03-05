package com.cihanalidev.microstockproduct.repository.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.cihanalidev.microstock.constant.MicroStockProductConstants;
import com.cihanalidev.microstockproduct.model.ProductSequence;
import com.cihanalidev.microstockproduct.repository.interfaces.ProductSequenceRepositoryCustom;

@Repository
public class ProductSequenceRepositoryImpl implements ProductSequenceRepositoryCustom {

	@Autowired
	private MongoTemplate mongoTemplate;

	public Long getSequenceBy() {
		ProductSequence productSequence = mongoTemplate.findById(MicroStockProductConstants.PRODUCT_SEQUENCE_ID_FIELD, ProductSequence.class);
		if (productSequence != null) {
			productSequence.setSequence(productSequence.getSequence() + 1); ;
			Query query = new Query();
			query.addCriteria(Criteria.where(MicroStockProductConstants.ID).is(MicroStockProductConstants.PRODUCT_SEQUENCE_ID_FIELD));
			Update update = new Update();
			update.inc(MicroStockProductConstants.PRODUCT_SEQUENCE_NO_FIELD, 1);
			mongoTemplate.updateFirst(query, update, ProductSequence.class);
		} else {
			productSequence = new ProductSequence();
			productSequence.setId(MicroStockProductConstants.PRODUCT_SEQUENCE_ID_FIELD);
			productSequence.setSequence(1L);
			productSequence = mongoTemplate.save(productSequence);
		}
		return productSequence.getSequence();
	}

}
