package com.visionaryCrofting.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "Stock",uniqueConstraints = {
        @UniqueConstraint(columnNames = "email")
})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class Stock implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "stock_id")
    private Long id;

    @Column(name = "nom")
    private String nom;
    @Column(name = "adresse")
    private String adresse;
    @Column(name = "tel")
    private String tel;
    @Column(name = "email",nullable = false,unique = true)
    private String email;
    @Column(name = "password")
    private String password;
    @OneToMany(cascade = CascadeType.ALL , mappedBy = "stock")
    //@JsonBackReference
    private List<Product> product;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "stock")
    //@JsonBackReference
    private List<AppelOffre> appelOffres;
}
