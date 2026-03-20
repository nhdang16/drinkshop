package com.be.drinkshop.dto;

import com.be.drinkshop.model.enums.DiscountAmountType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DiscountDTO {
    private String code;

    private DiscountAmountType discountAmountType;

    private Double amount;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private Integer quantity;

    private Double minimumOrderPrice;

    private Boolean isActive;

    private String description;
}
