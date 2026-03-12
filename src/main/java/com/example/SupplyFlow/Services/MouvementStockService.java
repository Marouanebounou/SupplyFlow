package com.example.SupplyFlow.Services;

import com.example.SupplyFlow.enums.TypeMouvement;
import com.example.SupplyFlow.models.Produit;
import com.example.SupplyFlow.models.StockMovement;
import com.example.SupplyFlow.repositories.ProduitRepository;
import com.example.SupplyFlow.repositories.StockMovementRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MouvementStockService {
    private final StockMovementRepository stockMovementRepository;
    private final ProduitRepository produitRepository;

    public MouvementStockService(StockMovementRepository stockMovementRepository , ProduitRepository produitRepository){
        this.produitRepository = produitRepository;
        this.stockMovementRepository = stockMovementRepository;
    }

    @Transactional
    public void saveMovement(int produitId , int quantity , TypeMouvement typeMouvement){
        Produit produit = produitRepository.findById(produitId).orElseThrow(() -> new IllegalArgumentException("invalide id"));
        if (typeMouvement == TypeMouvement.ENTREE){
            produit.setQuantity(produit.getQuantity() + quantity);
        } else if (typeMouvement == TypeMouvement.SORTIE) {
            if (quantity > produit.getQuantity()){
                throw new IllegalStateException("Stock insuffisant pour cette sortie !");
            }
            produit.setQuantity(produit.getQuantity() - quantity);
        }

        produitRepository.save(produit);
        stockMovementRepository.save(new StockMovement(quantity , typeMouvement , produit));

    }


}
