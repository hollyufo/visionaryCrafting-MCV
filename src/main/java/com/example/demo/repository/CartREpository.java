package com.example.demo.repository;

import com.example.demo.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import java.util.List;

@Repository
public interface CartREpository extends JpaRepository<Cart,Long> {

    List<Cart> findAllByClientId(Long id);
}
