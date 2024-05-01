package com.itau.backendchallenge.validator;

import com.itau.backendchallenge.model.JwtPayload;

public interface JwtValidator {
    boolean validate(JwtPayload claims);
}