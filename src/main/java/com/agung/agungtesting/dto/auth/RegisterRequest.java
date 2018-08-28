package com.agung.agungtesting.dto.auth;

import java.util.Date;

public class RegisterRequest {
    private String fullname;
    private String username;
    private String email;
    private String password;
    private String confirmPassword;
    private Date tanggalLahir;
    private String ktpId;
    private String ktpLokasi;

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public Date getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(Date tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public String getKtpId() {
        return ktpId;
    }

    public void setKtpId(String ktpId) {
        this.ktpId = ktpId;
    }

    public String getKtpLokasi() {
        return ktpLokasi;
    }

    public void setKtpLokasi(String ktpLokasi) {
        this.ktpLokasi = ktpLokasi;
    }
}
