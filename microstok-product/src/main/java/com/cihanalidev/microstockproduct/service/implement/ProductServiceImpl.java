package com.cihanalidev.microstockproduct.service.implement;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.cihanalidev.microstockproduct.dto.ProductDTO;
import com.cihanalidev.microstockproduct.mapper.Mapper;
import com.cihanalidev.microstockproduct.model.Product;
import com.cihanalidev.microstockproduct.repository.interfaces.ProductRepository;
import com.cihanalidev.microstockproduct.service.interfaces.ProductSequenceGenerateService;
import com.cihanalidev.microstockproduct.service.interfaces.ProductService;

@Component
public class ProductServiceImpl implements ProductService {

	@Autowired
	KafkaTemplate<Long, Product> kafkaTemplate;

	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	ProductSequenceGenerateService productSequenceGenerateService;

	private static final String TOPIC = "buyProduct";

	public void buyProduct(Product product) {
//		if(isProductExist()) {
//			
//		}
//			byte[] json = new ObjectMapper().writeValueAsBytes(product);
		kafkaTemplate.send(TOPIC, product.getProductId(), product);
		System.out.println("Message Send");
	}
	
	
	@Override
	public boolean isProductExist(Long productid) {
		return false;
	}



	@Override
	public List<ProductDTO> getProductsWithCategory(String category) {
		return productRepository.getProductsByCategory(category).stream().map(product -> {
			return Mapper.convertProductDtoFromModel(product);
		}).collect(Collectors.toList());
	}

	@Override
	public ProductDTO getProductByName(String name) {
		Product product = productRepository.getProductByName(name);
		return Mapper.convertProductDtoFromModel(product);
	}

	@Override
	public ProductDTO getProductById(Long productId) {
		return Mapper.convertProductDtoFromModel(productRepository.getProductById(productId));
	}

	@Override
	public void addProduct(ProductDTO productDto) {
		productDto.setProductId(productSequenceGenerateService.getSequenceNumber());
		productRepository.save(Mapper.convertProductModelFromDto(productDto));
	}

	@Override
	public void deleteProductByName(String name) {
		Product product = productRepository.getProductByName(name);
		if (product != null) {
			System.out.println("delete product" + product.getName());
			productRepository.delete(product);
		}
	}

}
