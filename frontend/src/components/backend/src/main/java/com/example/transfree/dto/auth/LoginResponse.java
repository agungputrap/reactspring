package com.agung.agungtesting.dto.auth;

import com.agung.agungtesting.domain.Pengguna;

import java.util.List;

public class LoginResponse {
    String idToken;
    List<String> listMenu;
    Pengguna pengguna;
    Long roleId;

    public LoginResponse(String idToken, List<String> listMenu, Pengguna pengguna) {
        this.idToken = idToken;
        this.listMenu = listMenu;
        this.pengguna = pengguna;
    }

    public LoginResponse(String idToken, List<String> listMenu, Pengguna pengguna, Long roleId) {
        this.idToken = idToken;
        this.listMenu = listMenu;
        this.pengguna = pengguna;
        this.roleId = roleId;
    }

    public LoginResponse(String idToken, Pengguna pengguna, Long roleId) {
        this.idToken = idToken;
        this.pengguna = pengguna;
        this.roleId = roleId;
    }

    public String getIdToken() {
        return idToken;
    }

    public void setIdToken(String idToken) {
        this.idToken = idToken;
    }

    public List<String> getListMenu() {
        return listMenu;
    }

    public void setListMenu(List<String> listMenu) {
        this.listMenu = listMenu;
    }

    public Pengguna getPengguna() {
        return pengguna;
    }

    public void setPengguna(Pengguna pengguna) {
        this.pengguna = pengguna;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}
