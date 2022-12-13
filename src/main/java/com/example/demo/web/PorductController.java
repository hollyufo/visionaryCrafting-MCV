package com.example.demo.web;

import com.example.demo.entities.Product;
import com.example.demo.service.impliemntation.ProductServiceImp;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
@RequestMapping("/product")
public class PorductController {
    private ProductServiceImp productServiceImp;
    // get all the products
    @GetMapping("/all")
    public String getProducts(Model model){
        List<Product> products = productServiceImp.getAll();
        model.addAttribute("products", products);
        return "product";
    }
    // display one product
    @GetMapping("/{id}")
    public String getProduct(Model model, @PathVariable Long id){
        Product product = productServiceImp.findById(id);
        model.addAttribute("product", product);
        return "singleproduct";
    }
}
