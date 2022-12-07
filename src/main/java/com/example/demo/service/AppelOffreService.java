package com.example.demo.service;

import com.example.demo.entities.AppelOffre;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface AppelOffreService {
    int deleteByRef(String ref);
    
    AppelOffre findByRef(String ref);

    List<AppelOffre> findAll();

    AppelOffre getOne(Long aLong);

    AppelOffre save(AppelOffre appelOffre);

    AppelOffre update(AppelOffre appelOffre);

    List<AppelOffre> getAll();
}
