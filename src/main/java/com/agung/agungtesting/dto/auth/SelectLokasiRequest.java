package com.agung.agungtesting.dto.auth;

public class SelectLokasiRequest {
    private Long idLokasi;
    private Long idPrevAbsensi;

    public Long getIdLokasi() {
        return idLokasi;
    }

    public void setIdLokasi(Long idLokasi) {
        this.idLokasi = idLokasi;
    }

    public Long getIdPrevAbsensi() {
        return idPrevAbsensi;
    }

    public void setIdPrevAbsensi(Long idPrevAbsensi) {
        this.idPrevAbsensi = idPrevAbsensi;
    }
}
