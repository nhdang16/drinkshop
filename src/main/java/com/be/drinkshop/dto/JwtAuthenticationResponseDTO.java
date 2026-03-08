package com.be.drinkshop.dto;

import com.be.drinkshop.model.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class JwtAuthenticationResponseDTO {
    private String token;
    private String fullName;
    private UserRole role;
}
