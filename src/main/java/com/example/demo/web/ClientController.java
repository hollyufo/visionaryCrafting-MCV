package com.example.demo.web;


import com.example.demo.entities.Client;
import com.example.demo.service.impliemntation.ClientServiceImp;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
@RequestMapping("/client")
public class ClientController {
    private ClientServiceImp clientServiceImp;
    @GetMapping("/all")
    public String getClients(Model model){
        List<Client> clients = clientServiceImp.getAllClients();
        model.addAttribute("clientslist", clients);
        return "clients";
    }
    // adding new clients to the database from the form
    @PostMapping("/add")
    public String addClient(@RequestParam String email, @RequestParam String phone, @RequestParam String password){
        Client client = new Client();
        client.setPassword(password);
        client.setEmail(email);
        client.setTel(phone);
        clientServiceImp.addClient(client);
        return "redirect:/client/all";
    }
    // getting the client by id

    @GetMapping("/edit/{id}")
    public String getClientById(@RequestParam("id") Long id, Model model){
        Client client = clientServiceImp.getOnById(id);
        model.addAttribute("client", client);
        return "edit-client";
    }
    // deleting the client by id
    @GetMapping("/delete/{id}")
    public String deleteClientById(@RequestParam("id") Long id){
        clientServiceImp.deleteClient(id);
        return "redirect:/client/all";
    }
}
