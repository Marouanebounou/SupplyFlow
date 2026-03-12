package com.example.SupplyFlow.models;

import com.example.SupplyFlow.enums.TypeMouvement;
import jakarta.persistence.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class StockMovement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    TypeMouvement type;

    private int quantity;

    private LocalDateTime date;

    private int product_id;

    @ManyToOne
    @JoinColumn(name = "produit_id" , nullable = false)
    private Produit produit;

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public StockMovement(int quantite, TypeMouvement type, Produit produit) {
        this.quantity = quantite;
        this.type = type;
        this.produit = produit;
        this.product_id = produit.getId();
        this.date = LocalDateTime.now();
    }

    public StockMovement() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TypeMouvement getType() {
        return type;
    }

    public void setType(TypeMouvement type) {
        this.type = type;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }
}
