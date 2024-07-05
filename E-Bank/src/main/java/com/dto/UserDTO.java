package com.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDTO {
    private Long userId;
    private String nom;
    private String email;
    private String motDePasse;
}
