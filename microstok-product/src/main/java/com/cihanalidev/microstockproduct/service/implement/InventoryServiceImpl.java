package com.cihanalidev.microstockproduct.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cihanalidev.microstock.constant.MicroStockProductConstants;
import com.cihanalidev.microstockproduct.dto.DecreaseProductCountDTO;
import com.cihanalidev.microstockproduct.dto.InventoryDTO;
import com.cihanalidev.microstockproduct.mapper.Mapper;
import com.cihanalidev.microstockproduct.model.Inventory;
import com.cihanalidev.microstockproduct.repository.interfaces.InventoryRepository;
import com.cihanalidev.microstockproduct.service.interfaces.InventoryService;

@Component 
public class InventoryServiceImpl implements InventoryService {

	@Autowired
	InventoryRepository inventoryRepository;

	@Override
	public void saveOrUpdateProductInventory(InventoryDTO inventoryDTO) {
		Inventory inventory = inventoryRepository.findByProductId(inventoryDTO.getProductId())
				.orElseGet(Inventory::new);
		Mapper.convertInventoryModelFromDto(inventoryDTO, inventory);
		inventoryRepository.save(inventory);
	}

	@Override
	public void decreaseProductCountAfterSales(DecreaseProductCountDTO decreaseProductCountDTO) throws Exception {
		Inventory inventory = inventoryRepository.findByProductId(decreaseProductCountDTO.getProductId())
				.orElseThrow(() -> new Exception(MicroStockProductConstants.ERROR_DONT_EXIST_PRODUCT));
		if (inventory.getCount() < decreaseProductCountDTO.getProductSalesCount()) {
			throw new Exception(MicroStockProductConstants.ERROR_NOT_ENOUGH_PRODUCT_COUNT);
		}
		inventory.setCount(inventory.getCount() - decreaseProductCountDTO.getProductSalesCount());
		inventoryRepository.save(inventory);

	}

	@Override
	public void addProductCount(InventoryDTO inventoryDTO) {
		Inventory inventory = inventoryRepository.findByProductId(inventoryDTO.getProductId()).get();
		inventory.setCount(inventory.getCount() + inventoryDTO.getCount());
		inventoryRepository.save(inventory);
	}

	abstract public class Elephant {
		abstract private class SleepsAlot {
			abstract int sleep();
		}
	}

	@Override
	public void aa() {
		// TODO Auto-generated method stub
		
	}
	
}
