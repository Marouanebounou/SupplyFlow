package com.example.SupplyFlow.Controllers;

import com.example.SupplyFlow.models.Produit;
import com.example.SupplyFlow.repositories.ProduitRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/produits")
public class ProductController {

    private ProduitRepository produitRepository ;

    public ProductController(ProduitRepository produitRepository){
        this.produitRepository = produitRepository;
    }

    @GetMapping
    public String listerProduits(Model model){
        model.addAttribute("produits" , produitRepository.findAll());
        return "produits/liste";
    }

    @GetMapping("/new")
    public String afficherFormulaireCreation(Model model){
        model.addAttribute("produit" , new Produit());
        return "produits/formulaire";
    }

    @PostMapping("/save")
    public String saveProduit(@ModelAttribute("produit") Produit produit){
        produitRepository.save(produit);
        return "redirect:/produits";
    }

    @GetMapping("/update/{id}")
    public String afficherFormulaireModification(@PathVariable("id") int id , Model model){
        Produit produit = produitRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Id Produit invalide"));
        model.addAttribute("produit" , produit);
        return "produits/formulaire";

    }

    @GetMapping("/delete/{id}")
    public String deleteProduit(@PathVariable("id") int id){
        produitRepository.deleteById(id);
        return "redirect:/produits";
    }



}
