package com.example.SupplyFlow.repositories;

import com.example.SupplyFlow.models.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduitRepository extends JpaRepository<Produit , Integer> {}
