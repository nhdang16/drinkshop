package com.be.drinkshop.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UpdateProductDTO {
    private String name;
    private Double price;
    private String description;
    private String image;
    private String ingredients;
    private Long categoryId;
}
