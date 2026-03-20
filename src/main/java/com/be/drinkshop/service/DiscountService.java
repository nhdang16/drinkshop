package com.be.drinkshop.service;

import com.be.drinkshop.dto.DiscountDTO;
import com.be.drinkshop.model.Discount;

import java.util.List;
import java.util.Optional;

public interface DiscountService {
    List<Discount> getAllDiscounts();

    List<Discount> getAllActiveDiscounts();

    Optional<Discount> getDiscountById(Long id);

    Discount createDiscount(DiscountDTO discount);

    Discount updateDiscount(Long id, DiscountDTO discountDetails);

    void updateDiscountStatus(Long id, boolean isActive);

    void deleteDiscount(Long id);
}
