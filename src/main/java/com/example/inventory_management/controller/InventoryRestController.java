package com.example.inventory_management.controller;


import com.example.inventory_management.dto.ItemDTO;
import com.example.inventory_management.dto.StockMovementDTO;
import com.example.inventory_management.dto.SupplierDTO;
import com.example.inventory_management.entity.Item;
import com.example.inventory_management.entity.Supplier;
import com.example.inventory_management.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/inventory")
public class InventoryRestController {
    private final InventoryService inventoryService;

    @Autowired
    public InventoryRestController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @PostMapping("/suppliers")
    public ResponseEntity<SupplierDTO> createSupplier(@RequestBody SupplierDTO supplierDTO) {
        Supplier supplier = inventoryService.createSupplier(supplierDTO);
        SupplierDTO responseDTO = new SupplierDTO();
        responseDTO.setName(supplier.getName());
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @PostMapping("/items")
    public ResponseEntity<ItemDTO> createItem(@RequestBody ItemDTO itemDTO) {
        Item item = inventoryService.createItem(itemDTO);
        ItemDTO responseDTO = new ItemDTO();
        responseDTO.setId(item.getId());
        responseDTO.setName(item.getName());
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @PostMapping("/stock-movements")
    public ResponseEntity<String> addStockMovement(@RequestBody StockMovementDTO stockMovementDTO) {
        String result = inventoryService.addStockMovement(stockMovementDTO);
        return ResponseEntity.ok(result);
    }
}