package com.agung.agungtesting.dto;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class CustomUser extends User {

    int idRole;
    String role;

    public CustomUser(String username, String password, Collection<? extends GrantedAuthority> authorities, int idRole, String role) {
        super(username, password, authorities);
        this.idRole = idRole;
        this.role = role;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
