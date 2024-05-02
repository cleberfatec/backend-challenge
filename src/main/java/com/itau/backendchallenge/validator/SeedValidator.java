package com.itau.backendchallenge.validator;

import com.itau.backendchallenge.model.JwtPayload;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
class SeedValidator implements JwtValidator {
    @Override
    public boolean validate(JwtPayload claims) {
        int seed = claims.Seed();
        boolean valid = isPrime(seed);
        if (!valid) {
            log.error("A claim Seed deve ser um número primo.");
        }
        return valid;
    }

    private boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}