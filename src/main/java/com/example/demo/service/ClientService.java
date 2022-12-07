package com.example.demo.service;

import com.example.demo.entities.Client;

import java.util.List;
import java.util.Optional;

public interface ClientService {
    List<Client> getAllClients();
    Optional<Client> getOnById(Long id);
    Client addClient(Client client);
    Client updateClient(Long id,Client client);
}
