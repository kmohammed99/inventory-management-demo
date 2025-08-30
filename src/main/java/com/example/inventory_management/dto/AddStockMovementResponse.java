package com.example.inventory_management.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "addStockMovementResponse")
public class AddStockMovementResponse {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}