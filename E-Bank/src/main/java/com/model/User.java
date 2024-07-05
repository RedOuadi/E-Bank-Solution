package com.model;

import jakarta.persistence.Id;
import lombok.*;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    private String nom;
    private String email;
    private String motDePasse;

    @OneToMany(mappedBy = "user")
    private List<CompteBancaire> comptes;
}

