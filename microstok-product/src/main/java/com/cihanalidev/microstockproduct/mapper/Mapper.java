package com.cihanalidev.microstockproduct.mapper;

import java.util.Date;

import com.cihanalidev.microstockproduct.dto.InventoryDTO;
import com.cihanalidev.microstockproduct.dto.ProductDTO;
import com.cihanalidev.microstockproduct.model.Inventory;
import com.cihanalidev.microstockproduct.model.Product;

public class Mapper {

	public static ProductDTO convertProductDtoFromModel(Product model) {
		ProductDTO productDTO = new ProductDTO();
		if (model != null) {
			productDTO.setBrand(model.getBrand());
			productDTO.setCategory(model.getCategory());
			productDTO.setName(model.getName());
			productDTO.setPrice(model.getPrice());
			productDTO.setProductId(model.getProductId());
		}
		return productDTO;
	}

	public static Product convertProductModelFromDto(ProductDTO productDto) {
		Product product = new Product();
		if (productDto != null) {
			product.setBrand(productDto.getBrand());
			product.setCategory(productDto.getCategory());
			product.setName(productDto.getName());
			product.setPrice(productDto.getPrice());
			product.setProductId(productDto.getProductId());
		}
		return product;
	}

	public static void convertInventoryModelFromDto(InventoryDTO inventoryDTO, Inventory inventory) {
		inventory = inventory == null ? new Inventory() : inventory;
		inventory.setDate(new Date());
		inventory.setPersonalId(inventoryDTO.getPersonalId() == null ? inventory.getPersonalId() : inventoryDTO.getPersonalId());
		inventory.setProductId(inventoryDTO.getProductId() == null ? inventory.getProductId() : inventoryDTO.getProductId());
		inventory.setCount(inventoryDTO.getCount() == null ? inventory.getCount() : inventoryDTO.getCount());
	}

}
