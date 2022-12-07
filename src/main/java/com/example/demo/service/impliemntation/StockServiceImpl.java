package com.example.demo.service.impliemntation;
import com.example.demo.entities.AppelOffre;
import com.example.demo.entities.Product;
import com.example.demo.entities.Stock;
import com.example.demo.repository.StockRepository;
import com.example.demo.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;


@Service
public class StockServiceImpl implements StockService {
    private Product product;
    private AppelOffreServiceImpl appelOffreServiceImpl;
    @Autowired
    StockRepository repository;

    @Override
    public Stock save(Stock stock) {
        return repository.save(stock);
    }
    public void deleteById(Long id){
        repository.deleteById(id);
    }

    @Override
    public Stock updateStock(Stock stock){
        return  repository.save(stock);
    }

    @Override
    public Optional<Stock> getById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Stock> getAll() {
        return repository.findAll();
    }

    @Override
    public Specification<AppelOffre> getSpec(String refProduit, String status, String fournisseur) {
        return ((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if(refProduit!=null && !(refProduit.isEmpty())){
                predicates.add((Predicate) criteriaBuilder.equal(root.get("refProduit"),refProduit));
            }if(status!=null && !(status.getClass().getName().isEmpty())){
                predicates.add((Predicate) criteriaBuilder.equal(root.get("status"),status));
            }
            return criteriaBuilder.and(predicates.toArray(new javax.persistence.criteria.Predicate[0]));

        });
    }

    @Override
    public Collection<AppelOffre> search(String refProduit, String status, String fournisseur) {
        return repository.findAllAppelDoffreByStatus(status);
    }
}
