package com.example.inventory_management.entity;


import javax.persistence.*;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false, unique = true)
    private String sku;
    @ManyToOne
    private Supplier supplier;
    @Column(nullable = false)
    private int quantity = 0;
    @Column(nullable = false)
    private int minQuantity = 0;

    public Item(String name, Long id, String sku, Supplier supplier, int quantity, int minQuantity) {
        this.name = name;
        this.id = id;
        this.sku = sku;
        this.supplier = supplier;
        this.quantity = quantity;
        this.minQuantity = minQuantity;
    }

    public Item() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getMinQuantity() {
        return minQuantity;
    }

    public void setMinQuantity(int minQuantity) {
        this.minQuantity = minQuantity;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sku='" + sku + '\'' +
                ", supplier=" + supplier +
                ", quantity=" + quantity +
                ", minQuantity=" + minQuantity +
                '}';
    }
}