package com.example.demo.service;

import com.example.demo.entities.Commande;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CommandService {
    List<Commande> getAllCommande();
    Commande getCommandeById(Long id);
    Commande getCommandeByRef(String ref);
    Commande addCommande(Commande commande);
    String deleteCommande(Long id);
}
