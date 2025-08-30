package com.example.inventory_management.repository;

import com.example.inventory_management.entity.StockMovement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StockMovementRepository extends JpaRepository<StockMovement, Long> {
}