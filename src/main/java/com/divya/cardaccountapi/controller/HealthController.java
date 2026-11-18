package com.divya.cardaccountapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController 
public class HealthController {

    @GetMapping("/health")
    public String healthCheck(){
        return "Card Account API is up and running";
    }
}
