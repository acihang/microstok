package com.cihanalidev.microstockproduct.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cihanalidev.microstockproduct.dto.InventoryDTO;
import com.cihanalidev.microstockproduct.dto.ProductDTO;
import com.cihanalidev.microstockproduct.model.Product;
import com.cihanalidev.microstockproduct.request.RequestAddProduct;
import com.cihanalidev.microstockproduct.request.RequestDeleteProductByName;
import com.cihanalidev.microstockproduct.request.RequestGetProductByName;
import com.cihanalidev.microstockproduct.request.RequestProductById;
import com.cihanalidev.microstockproduct.request.RequestProductByName;
import com.cihanalidev.microstockproduct.request.RequestProductInventory;
import com.cihanalidev.microstockproduct.response.ResponseProduct;
import com.cihanalidev.microstockproduct.response.ResponseProductByCategory;
import com.cihanalidev.microstockproduct.service.interfaces.InventoryService;
import com.cihanalidev.microstockproduct.service.interfaces.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@Autowired
	private InventoryService inventoryService;

	@PostMapping("/1.0/buyProduct")
	public String buyProduct(@RequestBody Product product) {
//		productService.buyProduct(product);
		return "Success";
	}

	@PostMapping("/1.0/addProduct")
	public String addProduct(@RequestBody RequestAddProduct request) {
		ProductDTO productDto = new ProductDTO();
		productDto.setBrand(request.getBrand());
		productDto.setCategory(request.getCategory());
		productDto.setName(request.getName());
		productDto.setPrice(request.getPrice());
		productDto.setProductId(request.getProductId());
		productService.addProduct(productDto);
		return "Success";
	}

	@PostMapping("/1.0/deleteProductByName")
	public String deleteProductByName(@RequestBody RequestDeleteProductByName request) {
		productService.deleteProductByName(request.getName());
		return "Success";
	}

	@GetMapping("/1.0/getProductByName")
	public ResponseProduct getProductByName(@RequestBody RequestProductByName request) {
		ResponseProduct response = new ResponseProduct();
		response.setProductDto(productService.getProductByName(request.getName()));
		return response;
	}

	@GetMapping("/1.0/getProductByCategory")
	public ResponseProductByCategory getProductByCategory(@RequestBody RequestGetProductByName request) {
		ResponseProductByCategory response = new ResponseProductByCategory();
		response.setListProductDto(productService.getProductsWithCategory(request.getName()));
		return response;
	}

	@PostMapping("/1.0/getProductById")
	public ResponseProduct getProductById(@RequestBody RequestProductById request) {
		ResponseProduct response = new ResponseProduct();
		response.setProductDto(productService.getProductById(request.getProductId()));
		return response;
	}

	@PostMapping("/1.0/addProductInventory")
	public String addProductInventory(@RequestBody RequestProductInventory request) {
		InventoryDTO inventoryDTO = new InventoryDTO();
		inventoryDTO.setCount(request.getCount());
		inventoryDTO.setPersonalId(request.getPersonalId());
		inventoryDTO.setProductId(request.getProductId());
		inventoryService.saveOrUpdateProductInventory(inventoryDTO);
		return "Success";
	}

}
