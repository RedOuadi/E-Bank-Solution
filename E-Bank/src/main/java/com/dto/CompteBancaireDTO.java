package com.dto;

import lombok.Data;

@Data
public class CompteBancaireDTO {
    private int compteId;
    private String typeCompte;
    private float solde;
    private String dateCreation;
}
