package com.be.drinkshop.model;

import com.be.drinkshop.model.enums.DiscountAmountType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "discount")
public class Discount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;

    @Enumerated(EnumType.STRING)
    private DiscountAmountType discountAmountType;

    private Double amount;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private Integer quantity;

    private Double minimumOrderPrice;

    private Boolean isActive;

    private String description;
}
