package com.example.SupplyFlow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

@Entity
public class StockMovement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String type;

    private int quantity;

    private LocalDate date;

    private int product_id;

}
