package com.cihanalidev.microstockproduct.dto;

public class DecreaseProductCountDTO {

	private Long productId;
	private Integer productSalesCount;

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Integer getProductSalesCount() {
		return productSalesCount;
	}

	public void setProductSalesCount(Integer productSalesCount) {
		this.productSalesCount = productSalesCount;
	}

}
