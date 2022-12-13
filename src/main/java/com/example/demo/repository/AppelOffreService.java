package com.example.demo.repository;

import com.example.demo.entities.AppelOffre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppelOffreService extends JpaRepository<AppelOffre,Long> {
    int deleteByRef(String ref);
    AppelOffre findByRef(String ref);




}
