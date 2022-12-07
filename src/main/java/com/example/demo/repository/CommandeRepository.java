package com.example.demo.repository;

import com.example.demo.entities.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CommandeRepository extends JpaRepository<Commande,Long> {
    Commande findByRef(String ref);

    void deleteByRef(String ref);
}
