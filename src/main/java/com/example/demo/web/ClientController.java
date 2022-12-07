package com.example.demo.web;


import com.example.demo.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class ClientController {
    private ClientRepository clientRepository;
    @GetMapping("/clients")
    public String getClients(){
        return "clients";
    }
}
