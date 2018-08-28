package com.agung.agungtesting.auth;

import com.agung.agungtesting.dto.pengguna.PenggunaCustom;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.List;

public class UserAuthentication implements Authentication {

    private String jwtToken;
    private List<SimpleGrantedAuthority> listAuthorities;
    private PenggunaCustom pengguna;
    private boolean isAuthenticated;

    public UserAuthentication(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return listAuthorities;
    }

    @Override
    public Object getCredentials() {
        return jwtToken;
    }

    @Override
    public Object getDetails() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return pengguna;
    }

    @Override
    public boolean isAuthenticated() {
        return isAuthenticated;
    }

    @Override
    public void setAuthenticated(boolean b) throws IllegalArgumentException {
        this.isAuthenticated = b;
    }

    @Override
    public String getName() {
        return null;
    }

    public void setCredentials(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public void setAuthorities(List<SimpleGrantedAuthority> listAuthorities) {
        this.listAuthorities = listAuthorities;
    }

    public void setPrincipal(PenggunaCustom pengguna) {
        this.pengguna = pengguna;
    }
}
