package com.cihanalidev.microstockproduct.response;

import java.util.List;

import com.cihanalidev.microstockproduct.dto.ProductDTO;

public class ResponseProductByCategory {

	private List<ProductDTO> listProductDto;

	public List<ProductDTO> getListProductDto() {
		return listProductDto;
	}

	public void setListProductDto(List<ProductDTO> listProductDto) {
		this.listProductDto = listProductDto;
	}

}
