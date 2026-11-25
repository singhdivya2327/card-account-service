package com.divya.cardaccountapi.controller;

import java.util.List;

import com.divya.cardaccountapi.exception.AccountNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.divya.cardaccountapi.model.CardAccount;
import com.divya.cardaccountapi.model.CreateCardAccountRequest;
import com.divya.cardaccountapi.service.CardAccountService;

import jakarta.validation.Valid;


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
    public CardAccount getCardAccountById(@PathVariable Long id){
        return cardAccountService.getCardAccountById(id)
        .orElseThrow(() -> new AccountNotFoundException(id));

    }

    @PostMapping
    public ResponseEntity<CardAccount> createCardAccount(@Valid @RequestBody CreateCardAccountRequest request) {
    CardAccount created = cardAccountService.createCardAccount(
            request.getHolderName(), request.getMaskedCardNumber(), request.getBalance());
    return ResponseEntity.status(HttpStatus.CREATED).body(created);
}
}
