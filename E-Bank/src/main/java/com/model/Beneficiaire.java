package com.model;

import jakarta.persistence.*;


import jakarta.persistence.*;
import java.util.Set;

@Entity
public class Beneficiaire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "beneficiaire", cascade = CascadeType.ALL)
    private Set<Transfer> transfers;

    // Getters and setters
}

