package com.example.demo.web;

import com.example.demo.service.impliemntation.StockServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entities.Stock;

import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
@RequestMapping("/stock")
public class StockController {
    private StockServiceImpl stockService;

    @GetMapping("/all")
    public String getStocks(Model model){
        List<Stock> stocks = stockService.getAll();
        model.addAttribute("stockslist", stocks);
        return "stocks";
    }

    @GetMapping("/add")
    public String addStock(@RequestParam String name, @RequestParam String address, @RequestParam String tel, @RequestParam String email, @RequestParam String password){
        Stock stock = new Stock();
        stock.setNom(name);
        stock.setAdresse(address);
        stock.setTel(tel);
        stock.setEmail(email);
        stock.setPassword(password);
        stockService.save(stock);
        return "redirect:/stock/all";
    }
    // edit stock by id
    @GetMapping("/edit/{id}")
    public String getStockById(@RequestParam("id") Long id, Model model){
        Optional<Stock> stock = stockService.getById(id);
        model.addAttribute("stock", stock);
        return "edit-stock";
    }
    // update stock by id
    @PutMapping("/update/{id}")
    public String updateStockById(@RequestParam("id") Long id, @RequestParam String name, @RequestParam String address, @RequestParam String tel, @RequestParam String email, @RequestParam String password){
        Optional<Stock> stock = stockService.getById(id);
        stock.get().setNom(name);
        stock.get().setAdresse(address);
        stock.get().setTel(tel);
        stock.get().setEmail(email);
        stock.get().setPassword(password);
        return "redirect:/stock/all";
    }

}
