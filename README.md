# Inventory Management Demo  

Simple inventory management demo showcasing the same APIs exposed as **REST** and **SOAP**, with persistence in an in-memory **H2 database**.  

## Features  
- Manage **Suppliers**, **Items**, and **Stock Movements**.  
- Both **REST endpoints** and **SOAP services** available.  
- Auto-generated WSDL/XSD for SOAP.  
- H2 in-memory database (no setup needed).  

## Run the project  
```bash
mvn clean install
mvn spring-boot:run
```

H2 Console: http://localhost:8080/h2-console
JDBC URL: jdbc:h2:mem:invdb


## REST API

Base URL: http://localhost:8080/api/v1/inventory
- Create Supplier
POST /suppliers
{
  "name": "Supplier A",
  "email": "a@mail.com",
  "phone": "12345"
}

- Create Item
POST /items
{
  "name": "Item 1",
  "sku": "SKU",
  "supplierId": 2,
  "quantity": 3,
  "minQuantity": 3
}


- Add Stock Movement
POST /stock-movements
{
  "itemId": 1,
  "amount": 20,
  "note": "Initial stock"
}


## SOAP API
WSDL available at: http://localhost:8080/ws/inventory.wsdl

Example Requests
- Create Supplier
```
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:inv="http://example.com/inventory">
   <soapenv:Header/>
   <soapenv:Body>
      <inv:createSupplierRequest>
         <inv:name>Supplier A</inv:name>
         <inv:email>a@mail.com</inv:email>
         <inv:phone>12345</inv:phone>
      </inv:createSupplierRequest>
   </soapenv:Body>
</soapenv:Envelope>
```

- Create Item
```
<inv:createItemRequest xmlns:inv="http://example.com/inventory">
   <inv:name>Item 1</inv:name>
   <inv:sku>SKU001</inv:sku>
   <inv:supplierId>1</inv:supplierId>
   <inv:minQuantity>5</inv:minQuantity>
</inv:createItemRequest>
```

- Add Stock Movement
```
<inv:addStockMovementRequest xmlns:inv="http://example.com/inventory">
   <inv:itemId>1</inv:itemId>
   <inv:amount>20</inv:amount>
   <inv:note>Initial stock</inv:note>
</inv:addStockMovementRequest>
```
