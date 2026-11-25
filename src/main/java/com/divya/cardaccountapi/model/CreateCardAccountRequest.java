package com.divya.cardaccountapi.model;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public class CreateCardAccountRequest {

    @NotBlank private String holderName;
    @NotBlank private String maskedCardNumber;
    @NotNull @PositiveOrZero private BigDecimal balance;
    public CreateCardAccountRequest(String holderName, String maskedCardNumber, BigDecimal balance) {
        this.holderName = holderName;
        this.maskedCardNumber = maskedCardNumber;
        this.balance = balance;
    }
    public String getHolderName() {
        return holderName;
    }
    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }
    public String getMaskedCardNumber() {
        return maskedCardNumber;
    }
    public void setMaskedCardNumber(String maskedCardNumber) {
        this.maskedCardNumber = maskedCardNumber;
    }
    public BigDecimal getBalance() {
        return balance;
    }
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    

}
