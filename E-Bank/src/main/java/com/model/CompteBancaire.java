package com.model;


import lombok.*;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompteBancaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int compteId;

    private String typeCompte;
    private float solde;
    private Date dateCreation;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "compteBancaire")
    private List<Transaction> transactions;

    @OneToMany(mappedBy = "compteBancaire")
    private List<CarteBancaire> cartes;
}