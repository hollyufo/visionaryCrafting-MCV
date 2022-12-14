package com.example.demo.web;

import com.example.demo.entities.*;
import com.example.demo.service.impliemntation.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.Entity;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/cart")
public class CartController {
    private CartServiceimp cartServiceimp;
    private ProductServiceImp productServiceImp;
    private ClientServiceImp clientServiceImp;
    private CommandServiceImp commandServiceImp;

    private CommandItemServiceImp commandItemServiceImp;
    // get all the cart items belong to a client
    @RequestMapping("/all")
    public String getAllCartItems(Model model){
        // getting all the cart items where i di of client is 1
        Long userid = 1L;
        List<Cart> cartList = cartServiceimp.getAllCartItems(userid);
        model.addAttribute("cartList",cartList);
        return "cart";
    }
    // add a cart
    @RequestMapping("/add")
    public String addCartItem(Model model, @RequestParam String productid, @RequestParam String p_quantity){
        // searching for the product by id
        Long id = Long.parseLong(productid);
        Product product = productServiceImp.findById(id);
        // getting the client id
        Long clientid = 1L;
        Client client = clientServiceImp.getOnById(clientid);
        // saving the cart item
        Cart cart = new Cart();
        cart.setClient(client);
        cart.setProduct(product);
        cart.setQuantity(Integer.parseInt(p_quantity));
        cartServiceimp.addCartItem(cart);
        return "redirect:/product/all";
    }
    // checkout
    @RequestMapping("/checkout")
    public String checkout(@RequestParam String pids, @RequestParam String pquantity){
        // getting the client id
        Commande commande = new Commande();
        CommandeItem commandeItem = new CommandeItem();
        Long clientid = 1L;
        Client client = clientServiceImp.getOnById(clientid);
        // getting the product ids
        String[] ids = pids.split(",");
        // getting the product quantities
        String[] quantities = pquantity.split(",");
        // creating a new command
        commande.setClient(client);
        // setting the command date to the current date
        // getting the curennt date
        java.util.Date date = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        commande.setDate(sqlDate.toLocalDate());
        // generating a random string for ref
        String ref = java.util.UUID.randomUUID().toString();
        commande.setRef(ref);
        commande.setStatus("valid");
        // printing the pid and the quantity to console
        System.out.println("pids: "+pids);
        System.out.println("pquantity: "+pquantity);
        // saving the command
        Commande command1 = commandServiceImp.addCommande(commande);
        // total price
        double total = 0;
        // adding product command items
        for (int i = 0; i < ids.length; i++) {
            Long id = Long.parseLong(ids[i]);
            Product product = productServiceImp.findById(Long.valueOf(ids[i]));
            // adding the product commanditem
            commandeItem.setCommande(commande);
            commandeItem.setProduct(product);
            commandeItem.setQuantity(Integer.parseInt(quantities[i]));
            int price = (int) (product.getPrice() * Integer.parseInt(quantities[i]));
            commandeItem.setPrice(price);
            // generating a random string for ref
            String ref1 = java.util.UUID.randomUUID().toString();
            commandeItem.setRef(ref1);
            commandItemServiceImp.save(commandeItem);
            // resetting the commandeItem
            commandeItem = new CommandeItem();
            // adding the price to the total
            total += price;
        }
        // setting the total price
        commande.setPrixTotal(total);
        // updating the command
        commandServiceImp.addCommande(commande);
        // deleting the cart items
        return "redirect:/product/all";

    }
}
