package org.gyro.inventoryservice.service;

import org.gyro.inventoryservice.dto.InventoryResponse;
import org.gyro.inventoryservice.model.Inventory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import org.gyro.inventoryservice.repository.InventoryRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    @Transactional(readOnly=true)
    public List<InventoryResponse> getInventoryStatus(List<String> skuCodes) {
        List<Inventory> sku = inventoryRepository.findBySkuCodeIn(skuCodes);
        return inventoryRepository.findBySkuCodeIn(skuCodes).stream()
                .map(inventory -> InventoryResponse.builder()
                        .skuCode(inventory.getSkuCode())
                        .isInStock(inventory.getQuantity() > 0)
                        .build())
                .collect(Collectors.toList());
    }
}
