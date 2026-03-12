package com.example.SupplyFlow.Controllers;

import com.example.SupplyFlow.models.Supplier;
import com.example.SupplyFlow.repositories.SupplierRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/suppliers")
public class SupplierController {
    private SupplierRepository supplierRepository;
    public SupplierController(SupplierRepository supplierRepository){
        this.supplierRepository = supplierRepository;
    }
    @GetMapping
    public String listerSupplier(Model model){
        model.addAttribute("suppliers" , supplierRepository.findAll());
        return "suppliers/list";
    }

    @GetMapping("/new")
    public String addSupplier(Model model){
        model.addAttribute("supplier" , new Supplier());
        return "suppliers/form";
    }

    @PostMapping("/save")
    public String saveSupplier(@ModelAttribute Supplier supplier){
        supplierRepository.save(supplier);
        return "redirect:/suppliers";
    }

    @GetMapping("/update/{id}")
    public String updateSupplier(@PathVariable("id") int id ,  Model model){
        Supplier supplier = supplierRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Id fournisseur invalide"));
        model.addAttribute("supplier" , supplier);
        return "suppliers/form";
    }

    @GetMapping("/delete/{id}")
    public String deleteSupplier(@PathVariable("id") int id ){
        supplierRepository.deleteById(id);
        return "redirect:/suppliers";
    }
}
