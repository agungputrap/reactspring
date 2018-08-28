package com.agung.agungtesting.dto.auth;

public class SelectLokasiResponse {
    private Long idAbsensi;

    public SelectLokasiResponse(Long idAbsensi) {
        this.idAbsensi = idAbsensi;
    }

    public Long getIdAbsensi() {
        return idAbsensi;
    }

    public void setIdAbsensi(Long idAbsensi) {
        this.idAbsensi = idAbsensi;
    }
}
