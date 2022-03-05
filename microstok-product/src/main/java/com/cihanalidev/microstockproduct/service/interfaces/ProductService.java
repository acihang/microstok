package com.cihanalidev.microstockproduct.service.interfaces;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cihanalidev.microstockproduct.dto.ProductDTO;

@Component
public interface ProductService {

	List<ProductDTO> getProductsWithCategory(String category);

	ProductDTO getProductById(Long productId);

	ProductDTO getProductByName(String name);

	void addProduct(ProductDTO productDto);
	
	void deleteProductByName(String name);

	boolean isProductExist(Long productid);

}
