package com.example.inventory_management.dto;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "createSupplierResponse", namespace = "http://example.com/inventory")
@XmlAccessorType(XmlAccessType.FIELD)
public class CreateSupplierResponse {
    private Long supplierId;

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }
}