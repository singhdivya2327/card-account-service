package com.divya.cardaccountapi.model;

import java.math.BigDecimal;

public class CardAccount {
    private Long id;                  // unique identifier
    private String holderName;        // name of the card holder
    private String maskedCardNumber;  // something like **** **** **** 1234, never a full number
    private BigDecimal balance;        // use BigDecimal for money, never double
    private String status;             // ACTIVE, BLOCKED, or CLOSED for now

    public CardAccount(Long id, String holderName, String maskedCardNumber, BigDecimal balance, String status){ 
        this.id = id;
        this.holderName = holderName;
        this.maskedCardNumber = maskedCardNumber;
        this.balance = balance;
        this.status = status;

    } 

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
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
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    


}
