package com.agung.agungtesting.auth;

import org.springframework.security.core.AuthenticationException;

public class CustomAuthenticationException extends AuthenticationException {
    public CustomAuthenticationException(String msg, Throwable t) {
        super(msg, t);
    }
}
