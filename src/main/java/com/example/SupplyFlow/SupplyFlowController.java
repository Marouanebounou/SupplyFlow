package com.example.SupplyFlow;

import com.example.SupplyFlow.models.Produit;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

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

    @DeleteMapping("/product/delete/{id}")
    public void delete(@PathVariable int id){
        Produit produit = db.remove(id);
        if (produit == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/product/create")
    public Produit createProduit(Produit produit){
        db.put(Integer.parseInt(UUID.randomUUID().toString()), produit);
        return produit;
    }

}
