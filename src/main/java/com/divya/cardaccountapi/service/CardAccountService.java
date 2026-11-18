package com.divya.cardaccountapi.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.divya.cardaccountapi.model.CardAccount;
@Service 
public class CardAccountService {
    private List<CardAccount> cardAccounts = List.of(
        new CardAccount(1L, "Asha Rao", "**** **** **** 1234", new BigDecimal("2500.00"), "ACTIVE"),
            new CardAccount(2L, "Ravi Kumar", "**** **** **** 5678", new BigDecimal("320.50"), "ACTIVE"),
            new CardAccount(3L, "Meena Iyer", "**** **** **** 9012", new BigDecimal("0.00"), "BLOCKED")
    );
    public final List<CardAccount> getAllCardAccounts(){
        return cardAccounts;
    }
    public Optional<CardAccount> getCardAccountById(Long id){
        return cardAccounts.stream()
        .filter(account -> account.getId().equals(id))
        .findFirst();
    }
}
