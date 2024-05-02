package com.itau.backendchallenge.validator;

import com.itau.backendchallenge.model.JwtPayload;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
class RoleValidator implements JwtValidator {
    @Override
    public boolean validate(JwtPayload claims) {
        String role = claims.Role();
        boolean valid = role != null && (role.equals("Admin") || role.equals("Member") || role.equals("External"));
        if (!valid) {
            log.error("A claim Role deve conter apenas 1 dos três valores (Admin, Member e External)");
        }
        return valid;
    }
}
