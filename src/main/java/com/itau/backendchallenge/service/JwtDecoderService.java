package com.itau.backendchallenge.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import com.itau.backendchallenge.model.JwtPayload;
import com.itau.backendchallenge.validator.JwtValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.List;

@Service
@Slf4j
public class JwtDecoderService {

    private final List<JwtValidator> validators;

    public JwtDecoderService(List<JwtValidator> validators) {
        this.validators = validators;
    }

    public boolean isJwtValid(String token) {
        String[] parts = token.split("\\.");

        if (parts.length != 3) {
            log.error("Deve ser um JWT válido");
            return false;
        }

        String payload = parts[1];

        byte[] decodedBytes = Base64.getDecoder().decode(payload);
        String jsonPayload = new String(decodedBytes);

        ObjectMapper mapper = new ObjectMapper();
        try {
            JwtPayload claims = mapper.readValue(jsonPayload, JwtPayload.class);

            for (JwtValidator validator : validators) {
                if (!validator.validate(claims)) {
                    return false;
                }
            }

            return true;
        } catch (UnrecognizedPropertyException exception) {
            log.error("Deve conter apenas 3 claims (Name, Role e Seed)");
            return false;
        } catch (Exception exception) {
            return false;
        }
    }
}