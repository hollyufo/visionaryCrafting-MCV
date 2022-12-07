package com.example.demo.repository;
import com.example.demo.entities.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FournisseurRepository extends JpaRepository<Fournisseur,Long> {
    // get fournisseur by email
    Fournisseur findByEmail(String email);
}
