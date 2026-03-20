package com.be.drinkshop.dto;

import com.be.drinkshop.model.Payment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDTO {
    private Double amount;
    private String paymentMethod;
    private String status;
    private LocalDateTime transactionDate;

    public static PaymentDTO fromEntity(Payment p) {
        PaymentDTO dto = new PaymentDTO();
        dto.setPaymentMethod(p.getPaymentMethod());
        dto.setStatus(p.getStatus() != null ? p.getStatus() : null);
        dto.setAmount(p.getAmount());
        return dto;
    }
}
