package com.example.demo.service;

import com.example.demo.entities.Client;

import java.util.List;
import java.util.Optional;

public interface ClientService {
    List<Client> getAllClients();
    Client addClient(Client client);
    Client updateClient(Long id,Client client);
}
