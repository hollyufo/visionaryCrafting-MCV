package com.example.demo.service;

import com.example.demo.entities.AppelOffre;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import com.example.demo.entities.Stock;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public interface StockService {
    Stock save(Stock stock);
    void deleteById(Long id);
    Stock updateStock(Stock stock);

    Optional<Stock> getById(Long id);
    List<Stock> getAll();
    Specification<AppelOffre> getSpec(String refProduit , String status , String fournisseur);

    Collection<AppelOffre> search(String refProduit , String status , String fournisseur);
}