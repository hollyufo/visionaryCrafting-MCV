package com.example.demo.service.impliemntation;

import com.example.demo.entities.Commande;
import com.example.demo.repository.CommandeRepository;
import com.example.demo.service.CommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommandServiceImp implements CommandService {
    @Autowired
    CommandeRepository commandeRepository;
    // get all commande
    @Override
    public List<Commande> getAllCommande(){
        return commandeRepository.findAll();
    }
    // get commande by id
    @Override
    public Commande getCommandeById(Long id){
        Commande stest = commandeRepository.findById(id).orElse(null);
        if (stest == null){
            throw new IllegalStateException("Commande not found");
        }else{
            return stest;
        }
    }
    // get commande by ref
    @Override
    public Commande getCommandeByRef(String ref){
        return commandeRepository.findByRef(ref);
    }
    // add commande
    @Override
    public Commande addCommande(Commande commande){
        // checkin if commande exist
        if (commandeRepository.findByRef(commande.getRef()) != null){
            throw new IllegalStateException("Commande existe déja");
            // checking if command values are empty
        }else if (commande.getRef() == null || commande.getRef().isEmpty() || commande.getRef().isBlank()){
            throw new IllegalStateException("please fill all the inputs");
        }else{
            return commandeRepository.save(commande);
        }
    }
    // delete commande
    @Override
    public String deleteCommande(Long id){
        commandeRepository.deleteById(id);
        return "Commande deleted";
    }
    public String deleteCommandeByRef(String ref){
        commandeRepository.deleteByRef(ref);
        return "Commande deleted";
    }
}
