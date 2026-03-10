package com.example.SupplyFlow;

import models.Produit;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController

public class SupplyFlowController {

    public Map<Integer, Produit> db = new HashMap<>() {
        {
            put(1 , new Produit(1 , "tlfaza"));
            put(2 , new Produit(2 , "tlaja"));
        }
    };




    @GetMapping("/")
    public String hello(){
        return "Hello world.";
    }

    @GetMapping("/products")
    public Collection<Produit> getProduits(){
        return db.values();
    }

    @GetMapping("/product/{id}")
    public Produit getProduit(@PathVariable int id){
        Produit produit = db.get(id);
        if (produit == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return produit;
    }

}
