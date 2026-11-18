package com.divya.cardaccountapi.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.divya.cardaccountapi.model.CardAccount;
import com.divya.cardaccountapi.service.CardAccountService;
@RestController 
@RequestMapping ("/accounts")
public class CardAccountController {
    private CardAccountService cardAccountService;
    
    public CardAccountController(CardAccountService cardAccountService){
        this.cardAccountService = cardAccountService;
    }
    @GetMapping
    public List<CardAccount> getAllCardAccounts(){
        return cardAccountService.getAllCardAccounts();
    }
    @GetMapping ("/{id}")
    public ResponseEntity<CardAccount> getCardAccountById(@PathVariable Long id){
        return cardAccountService.getCardAccountById(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());

    }
}
