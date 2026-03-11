package com.example.SupplyFlow.repositories;

import com.example.SupplyFlow.models.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier , Integer> {
}
