-- Create Supplier table
CREATE TABLE IF NOT EXISTS supplier (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255),
    phone VARCHAR(255)
    );

-- Create Item table
CREATE TABLE IF NOT EXISTS item (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    sku VARCHAR(255) NOT NULL UNIQUE,
    supplier_id BIGINT,
    quantity INT NOT NULL DEFAULT 0,
    min_quantity INT NOT NULL DEFAULT 0,
    FOREIGN KEY (supplier_id) REFERENCES supplier(id)
    );

-- Create StockMovement table
CREATE TABLE IF NOT EXISTS stock_movement (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    item_id BIGINT,
    amount INT,
    note VARCHAR(255),
    FOREIGN KEY (item_id) REFERENCES item(id)
    );

-- Add some test data if needed
INSERT INTO supplier (name, email, phone) VALUES ('Supplier 1', 'supplier1@example.com', '123456789');
INSERT INTO item (name, sku, supplier_id, quantity, min_quantity) VALUES ('Item 1', 'SKU001', 1, 100, 10);
