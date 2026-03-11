package com.example.SupplyFlow.repositories;

import com.example.SupplyFlow.models.StockMovement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockMovementRepository extends JpaRepository<StockMovement , Integer> {
}
