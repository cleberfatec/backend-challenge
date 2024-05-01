package com.itau.backendchallenge.controller;

import com.itau.backendchallenge.service.JwtDecoderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JwtValidationController {

    private JwtDecoderService jwtDecoderService;

    public JwtValidationController(JwtDecoderService jwtDecoderService) {
        this.jwtDecoderService = jwtDecoderService;
    }

    @GetMapping("/decodeToken")
    public String decodeToken(@RequestHeader("Authorization") String token) {

        token = token.substring(7);
        
        return jwtDecoderService.isJwtValid(token) ? "verdadeiro" : "falso";

    }
}
