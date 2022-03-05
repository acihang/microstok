package com.cihanalidev.microstockproduct.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cihanalidev.microstockproduct.repository.interfaces.ProductSequenceRepository;
import com.cihanalidev.microstockproduct.service.interfaces.ProductSequenceGenerateService;

@Component
public class ProductSequenceGenerateServiceImpl implements ProductSequenceGenerateService {

	@Autowired
	ProductSequenceRepository productSequenceRepositoryImpl;

	@Override
	public Long getSequenceNumber() {
		return productSequenceRepositoryImpl.getSequenceBy();
	}

}
