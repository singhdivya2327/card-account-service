package com.divya.cardaccountapi.controller;

import java.util.LinkedHashMap;
import java.util.Map;


import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.RestController;

import com.nimbusds.jwt.JWT;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController 
public class WhoAmIController {
   
    @GetMapping("/whoami")
    public Map<String, Object> whoAmI(@AuthenticationPrincipal Jwt jwt){
        Map<String, Object> result =new LinkedHashMap<>();
        result.put("subject", jwt.getSubject());
        result.put("scope", jwt.getClaimAsString("scope"));
        result.put("expiresAt", jwt.getExpiresAt());
        return result;

    }

}
