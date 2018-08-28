package com.agung.agungtesting.dto.pengguna;

import java.util.List;

public class PenggunaResponse {
    String idToken;
    List<String> listMenu;
    PenggunaCustom pengguna;
    Long roleId;

    public PenggunaResponse(String idToken, PenggunaCustom pengguna, Long roleId) {
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

    public PenggunaCustom getPengguna() {
        return pengguna;
    }

    public void setPengguna(PenggunaCustom pengguna) {
        this.pengguna = pengguna;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}
