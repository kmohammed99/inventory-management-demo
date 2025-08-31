package com.example.inventory_management.service;

import com.example.inventory_management.dto.ItemDTO;
import com.example.inventory_management.dto.StockMovementDTO;
import com.example.inventory_management.dto.SupplierDTO;
import com.example.inventory_management.entity.Item;
import com.example.inventory_management.entity.StockMovement;
import com.example.inventory_management.entity.Supplier;
import com.example.inventory_management.repository.ItemRepository;
import com.example.inventory_management.repository.StockMovementRepository;
import com.example.inventory_management.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {

    private final ItemRepository itemRepo;
    private final SupplierRepository supplierRepo;
    private final StockMovementRepository stockMovementRepo;

    @Autowired
    public InventoryService(ItemRepository itemRepo,
                            SupplierRepository supplierRepo,
                            StockMovementRepository stockMovementRepo) {
        this.itemRepo = itemRepo;
        this.supplierRepo = supplierRepo;
        this.stockMovementRepo = stockMovementRepo;
    }

    public Supplier createSupplier(SupplierDTO supplierDTO) {
        Supplier supplier = new Supplier();
        supplier.setName(supplierDTO.getName());
        supplier.setEmail(supplierDTO.getEmail());
        supplier.setPhone(supplierDTO.getPhone());
        return supplierRepo.save(supplier);
    }

    public Item createItem(ItemDTO itemDTO) {
        Supplier supplier = supplierRepo.findById(itemDTO.getSupplierId())
                .orElseThrow(() -> new IllegalArgumentException("Supplier not found"));

        Item item = new Item();
        item.setName(itemDTO.getName());
        item.setSku(itemDTO.getSku());
        item.setMinQuantity(itemDTO.getMinQuantity());
        item.setSupplier(supplier);

        return itemRepo.save(item);
    }

    public List<Item> getAllItems() {
        return itemRepo.findAll();
    }

    public String addStockMovement(StockMovementDTO stockMovementDTO) {
        Item item = itemRepo.findById(stockMovementDTO.getItemId())
                .orElseThrow(() -> new IllegalArgumentException("Item not found"));

        item.setQuantity(item.getQuantity() + stockMovementDTO.getAmount());
        itemRepo.save(item);

        StockMovement movement = new StockMovement();
        movement.setItem(item);
        movement.setAmount(stockMovementDTO.getAmount());
        movement.setNote(stockMovementDTO.getNote());
        stockMovementRepo.save(movement);

        if (item.getQuantity() < item.getMinQuantity()) {
            return " Warning: Item " + item.getName() + " is minimum quantity!";
        }

        return " Stock movement recorded successfully.";
    }
}
