package com.example.inventory_management.controller;

import com.example.inventory_management.dto.*;
import com.example.inventory_management.entity.Item;
import com.example.inventory_management.entity.Supplier;
import com.example.inventory_management.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.w3c.dom.Element;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

@Endpoint
public class InventorySoapEndpoint {

    private static final String NAMESPACE_URI = "http://example.com/inventory";

    private final InventoryService inventoryService;

    @Autowired
    public InventorySoapEndpoint(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "createSupplierRequest")
    @ResponsePayload
    public JAXBElement<CreateSupplierResponse> createSupplier(@RequestPayload Element requestElement) {
        SupplierDTO supplierDTO = new SupplierDTO();
        supplierDTO.setName(requestElement.getElementsByTagNameNS(NAMESPACE_URI, "name").item(0).getTextContent());
        supplierDTO.setEmail(requestElement.getElementsByTagNameNS(NAMESPACE_URI, "email").item(0).getTextContent());
        supplierDTO.setPhone(requestElement.getElementsByTagNameNS(NAMESPACE_URI, "phone").item(0).getTextContent());

        Supplier supplier = inventoryService.createSupplier(supplierDTO);

        CreateSupplierResponse response = new CreateSupplierResponse();
        response.setSupplierId(supplier.getId());

        QName qName = new QName(NAMESPACE_URI, "createSupplierResponse");
        return new JAXBElement<>(qName, CreateSupplierResponse.class, response);
    }


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "createItemRequest")
    @ResponsePayload
    public JAXBElement<CreateItemResponse> createItem(@RequestPayload Element requestElement) {
        ItemDTO itemDTO = new ItemDTO();
        itemDTO.setName(requestElement.getElementsByTagNameNS(NAMESPACE_URI, "name").item(0).getTextContent());
        itemDTO.setSku(requestElement.getElementsByTagNameNS(NAMESPACE_URI, "sku").item(0).getTextContent());
        itemDTO.setSupplierId(Long.parseLong(requestElement.getElementsByTagNameNS(NAMESPACE_URI, "supplierId").item(0).getTextContent()));
        itemDTO.setMinQuantity(Integer.parseInt(requestElement.getElementsByTagNameNS(NAMESPACE_URI, "minQuantity").item(0).getTextContent()));
        Item item = inventoryService.createItem(itemDTO);

        CreateItemResponse response = new CreateItemResponse();
        response.setId(item.getId());
        response.setName(item.getName());
        response.setSku(item.getSku());
        response.setQuantity(item.getQuantity());
        response.setMinQuantity(item.getMinQuantity());

        QName qName = new QName(NAMESPACE_URI, "createItemResponse");
        return new JAXBElement<>(qName, CreateItemResponse.class, response);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addStockMovementRequest")
    @ResponsePayload
    public JAXBElement<AddStockMovementResponse> addStockMovement(@RequestPayload Element requestElement) {
        StockMovementDTO stockMovementDTO = new StockMovementDTO();
        stockMovementDTO.setItemId(Long.parseLong(requestElement.getElementsByTagNameNS(NAMESPACE_URI, "itemId").item(0).getTextContent()));
        stockMovementDTO.setAmount(Integer.parseInt(requestElement.getElementsByTagNameNS(NAMESPACE_URI, "amount").item(0).getTextContent()));
        stockMovementDTO.setNote(requestElement.getElementsByTagNameNS(NAMESPACE_URI, "note").item(0).getTextContent());

        String result = inventoryService.addStockMovement(stockMovementDTO);

        AddStockMovementResponse response = new AddStockMovementResponse();
        response.setMessage(result);

        QName qName = new QName(NAMESPACE_URI, "addStockMovementResponse");
        return new JAXBElement<>(qName, AddStockMovementResponse.class, response);
    }

}
