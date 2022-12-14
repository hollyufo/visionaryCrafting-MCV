package com.example.demo.service.impliemntation;

import com.example.demo.entities.Cart;
import com.example.demo.repository.CartREpository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceimp {
    @Autowired
    CartREpository cartRepository;

    // get all the cart items belong to a client
    public List<Cart> getAllCartItems(Long id){
        return cartRepository.findAllByClientId(id);
    }
    // add a cart item to a client
    public Cart addCartItem(Cart cart){
        return cartRepository.save(cart);
    }
    // delete a cart item with client id
    public void deleteCartItem(Long id){
        cartRepository.deleteById(id);
    }
}
