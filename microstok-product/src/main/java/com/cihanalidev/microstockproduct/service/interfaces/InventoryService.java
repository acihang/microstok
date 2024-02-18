package com.cihanalidev.microstockproduct.service.interfaces;

import org.springframework.stereotype.Component;

import com.cihanalidev.microstockproduct.dto.DecreaseProductCountDTO;
import com.cihanalidev.microstockproduct.dto.InventoryDTO;

@Component
public interface InventoryService {

	public void saveOrUpdateProductInventory(InventoryDTO inventoryDTO);

	public void decreaseProductCountAfterSales(DecreaseProductCountDTO decreaseProductCountDTO) throws Exception;

	public void addProductCount(InventoryDTO inventoryDTO);
	
}
