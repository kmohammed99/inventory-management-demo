package com.example.inventory_management.service;

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

    public Supplier createSupplier(String name, String email, String phone) {
        Supplier supplier = new Supplier();
        supplier.setName(name);
        supplier.setEmail(email);
        supplier.setPhone(phone);
        return supplierRepo.save(supplier);
    }

    public Item createItem(String name, String sku, Long supplierId, int minQuantity) {
        Supplier supplier = supplierRepo.findById(supplierId)
                .orElseThrow(() -> new IllegalArgumentException("Supplier not found"));

        Item item = new Item();
        item.setName(name);
        item.setSku(sku);
        item.setMinQuantity(minQuantity);
        item.setSupplier(supplier);

        return itemRepo.save(item);
    }

    public List<Item> getAllItems() {
        return itemRepo.findAll();
    }

    public String addStockMovement(Long itemId, int amount, String note) {
        Item item = itemRepo.findById(itemId)
                .orElseThrow(() -> new IllegalArgumentException("Item not found"));

        item.setQuantity(item.getQuantity() + amount);
        itemRepo.save(item);

        StockMovement movement = new StockMovement();
        movement.setItem(item);
        movement.setAmount(amount);
        movement.setNote(note);
        stockMovementRepo.save(movement);

        if (item.getQuantity() < item.getMinQuantity()) {
            return " Warning: Item " + item.getName() + " is minimum quantity!";
        }

        return " Stock movement recorded successfully.";
    }
}
