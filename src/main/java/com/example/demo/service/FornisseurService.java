package com.example.demo.service;

import com.example.demo.entities.AppelOffre;
import com.example.demo.entities.Fournisseur;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface FornisseurService {
    List<Fournisseur> getAllFournisseur();
    Fournisseur getFournisseurById(Long id);
    Fournisseur getFournisseurByEmail(String email);
    Fournisseur addFournisseur(Fournisseur fournisseur);
    String deleteFournisseur(Long id);
    Fournisseur updateFournisseur(Long id, Fournisseur fournisseur);
    AppelOffre validate(Long id_fournisseur , Long ao);
}
