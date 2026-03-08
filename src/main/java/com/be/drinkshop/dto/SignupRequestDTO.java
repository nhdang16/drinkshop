package com.be.drinkshop.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupRequestDTO {
    private String fullName;
    private String phoneNumber;
    private String email;
    private String password;
}
