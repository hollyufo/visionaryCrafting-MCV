package com.example.demo.web;

import com.example.demo.entities.Commande;
import com.example.demo.service.impliemntation.CommandServiceImp;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@AllArgsConstructor
@NoArgsConstructor
@RequestMapping("/command")
public class Commandcontroller {
    @Autowired
    private CommandServiceImp commandServiceImp;
    // get all the command
    @RequestMapping("/all")
    public String getAllCommand(Model model){
        List<Commande> commandList = commandServiceImp.getAllCommande();
        model.addAttribute("commandList",commandList);
        return "command";
    }
}
