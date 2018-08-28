package com.agung.agungtesting.auth;

import com.agung.agungtesting.exception.auth.TokenNotValidException;
import org.jose4j.lang.JoseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired JwtService jwtService;
    @Autowired AuthService authService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        try {
            log.info("CustomAuthenticationProvider.authenticate");

            if (authentication instanceof UserAuthentication) {
                UserAuthentication userAuthentication = (UserAuthentication) authentication;

                return authService.authenticate(userAuthentication);

            }
            /*else if (authentication instanceof AppAuthentication) {
                AppAuthentication appAuthentication = (AppAuthentication) authentication;

                return authService.authenticate(appAuthentication);
            }*/

            // TODO: sementara
            return authentication;
        } catch (JoseException e) {
            log.error("jose exception : ", e);
            throw new TokenNotValidException();
        } catch (Exception e) {
            log.error("authenticate : ", e);
            throw new CustomAuthenticationException("Failed to authenticate", e);
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        log.info("supports auth : {}", authentication);
        return UserAuthentication.class.equals(authentication) || AppAuthentication.class.equals(authentication);
    }
}
