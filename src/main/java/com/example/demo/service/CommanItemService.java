package com.example.demo.service;

import com.example.demo.entities.CommandeItem;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
public interface CommanItemService {
    List<CommandeItem> getAll() ;
    int count();
    CommandeItem save(CommandeItem t);
    CommandeItem update(CommandeItem t);
    void deleteById(Long id);

}
