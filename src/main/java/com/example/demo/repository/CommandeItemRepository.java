package com.example.demo.repository;

import com.example.demo.entities.CommandeItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CommandeItemRepository extends JpaRepository<CommandeItem,Long> {




}
