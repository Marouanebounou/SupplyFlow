package com.example.SupplyFlow.Controllers;

import com.example.SupplyFlow.Services.MouvementStockService;
import com.example.SupplyFlow.enums.TypeMouvement;
import com.example.SupplyFlow.repositories.ProduitRepository;
import com.example.SupplyFlow.repositories.StockMovementRepository;
import org.springframework.stereotype.Controller;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/stockMovement")
public class StockMouvementController {
    private final MouvementStockService mouvementStockService;
    private final ProduitRepository produitRepository;
    private final StockMovementRepository stockMovementRepository;

    public StockMouvementController(MouvementStockService mouvementStockService, ProduitRepository produitRepository, StockMovementRepository stockMovementRepository) {
        this.mouvementStockService = mouvementStockService;
        this.produitRepository = produitRepository;
        this.stockMovementRepository = stockMovementRepository;
    }

    @GetMapping
    public String lister(Model model){
        model.addAttribute("mouvements" , stockMovementRepository.findAll());
        return "stockMovement/liste";
    }

    @GetMapping("/new")
    public String newStockMovement(Model model){
        model.addAttribute("produits" , produitRepository.findAll());
        return "stockMovement/form";

    }

    @PostMapping("save")
    public String save(@RequestParam("produitId") int produitId,
                @RequestParam("quantite") int quantite,
                @RequestParam("type") TypeMouvement type,
                Model model){
        try {
            mouvementStockService.saveMovement(produitId, quantite, type);
            return "redirect:/stockMovement";

        } catch (Exception e) {
            model.addAttribute("erreur", e.getMessage());
            model.addAttribute("produits", produitRepository.findAll());
            return "stockMovement/form";
        }
    }

}
