package com.itau.backendchallenge.validator;

import com.itau.backendchallenge.model.JwtPayload;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
class NameValidator implements JwtValidator {
    @Override
    public boolean validate(JwtPayload claims) {
        String name = claims.Name();
        boolean valid = name != null && !name.isEmpty() && name.length() <= 256 && !containsDigits(name);
        if (!valid) {
            log.error("A claim Name não pode ter carácter de números");
        }
        return valid;

    }

    private boolean containsDigits(String s) {
        return s.matches(".*\\d.*");
    }
}