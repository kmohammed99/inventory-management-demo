package com.example.inventory_management.dto;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "createItemResponse", namespace = "http://example.com/inventory")
@XmlAccessorType(XmlAccessType.FIELD)
public class CreateItemResponse {
    private Long id;
    private String name;
    private String sku;
    private int quantity;
    private int minQuantity;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSku() { return sku; }
    public void setSku(String sku) { this.sku = sku; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public int getMinQuantity() { return minQuantity; }
    public void setMinQuantity(int minQuantity) { this.minQuantity = minQuantity; }
}
