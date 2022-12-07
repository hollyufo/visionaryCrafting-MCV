package com.example.demo.service;

import com.example.demo.entities.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ProductService {

    Optional<Product> getById(Long id);
    List<Product> getAll() ;
    int count();
    Product save(Product t);

    Product update(Product t);

    public void deleteById(Long id);
    Product findByRef(String ref);
    int deleteByRef(String ref);

    Product increaseQte(String ref,int qte);
    Product decreaseQte(String ref,int qte);
}