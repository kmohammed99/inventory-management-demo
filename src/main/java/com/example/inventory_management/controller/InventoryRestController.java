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
        Supplier supplier = inventoryService.createSupplier(supplierDTO.getName(), supplierDTO.getEmail(), supplierDTO.getPhone());
        SupplierDTO responseDTO = new SupplierDTO();
        responseDTO.setName(supplier.getName());
        responseDTO.setEmail(supplier.getEmail());
        responseDTO.setPhone(supplier.getPhone());
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }
    @PostMapping("/items")
    public ResponseEntity<ItemDTO> createItem(@RequestBody ItemDTO itemDTO) {
        Item item = inventoryService.createItem(itemDTO.getName(), itemDTO.getSku(), itemDTO.getSupplierId(), itemDTO.getMinQuantity());
        ItemDTO responseDTO = new ItemDTO();
        responseDTO.setId(item.getId());
        responseDTO.setName(item.getName());
        responseDTO.setSku(item.getSku());
        responseDTO.setQuantity(item.getQuantity());
        responseDTO.setMinQuantity(item.getMinQuantity());
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }
    @PostMapping("/stock-movements")
    public ResponseEntity<String> addStockMovement(@RequestBody StockMovementDTO stockMovementDTO) {
        String result = inventoryService.addStockMovement(
                stockMovementDTO.getItemId(),
                stockMovementDTO.getAmount(),
                stockMovementDTO.getNote()
        );
        return ResponseEntity.ok(result);
    }
}