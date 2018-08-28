package com.agung.agungtesting.auth;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.List;

public class AppAuthentication implements org.springframework.security.core.Authentication {
    private AppCredentials appCredentials;
    private List<SimpleGrantedAuthority> listAuthorities;
    //private App app;
    private boolean isAuthenticated;

    public AppAuthentication(AppCredentials appCredentials) {
        this.appCredentials = appCredentials;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return listAuthorities;
    }

    @Override
    public Object getCredentials() {
        return appCredentials;
    }

    @Override
    public Object getDetails() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        //return app;
        return null;
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

    public void setCredentials(AppCredentials appCredentials) {
        this.appCredentials = appCredentials;
    }

    public void setAuthorities(List<SimpleGrantedAuthority> listAuthorities) {
        this.listAuthorities = listAuthorities;
    }

    /*public void setPrincipal(App app) {
        this.app = app;
    }*/
}
