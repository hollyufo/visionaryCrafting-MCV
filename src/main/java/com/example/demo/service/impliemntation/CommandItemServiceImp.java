package com.example.demo.service.impliemntation;

import com.example.demo.entities.CommandeItem;
import com.example.demo.repository.CommandeItemRepository;
import com.example.demo.service.CommanItemService;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommandItemServiceImp implements CommanItemService {
    @Autowired
    CommandeItemRepository commandeItemRepository;
    @Autowired
    ProductService productService;

    public CommandeItem getById(Long id) {
        return commandeItemRepository.findById(id).get();
    }

    @Override
    public List<CommandeItem> getAll() {
        return commandeItemRepository.findAll();
    }

    @Override
    public int count() {
        return commandeItemRepository.findAll().size();
    }

    @Override
    public CommandeItem save(CommandeItem commandeItem) {
        return commandeItemRepository.save(commandeItem);
    }

    @Override
    public CommandeItem update(CommandeItem t) {return null;}

    @Override
    public void deleteById(Long id) {commandeItemRepository.deleteById(id);}
}