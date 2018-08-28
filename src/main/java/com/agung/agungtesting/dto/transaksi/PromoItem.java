package com.agung.agungtesting.dto.transaksi;

public class PromoItem {
    private Integer id;
    private String nama;
    private Double kurs;
    private Integer nominal;
    private Integer tipe;
    private String tipeNama;
    private String kursDari;
    private String kursKe;
    private Boolean aktif;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Double getKurs() {
        return kurs;
    }

    public void setKurs(Double kurs) {
        this.kurs = kurs;
    }

    public Integer getNominal() {
        return nominal;
    }

    public void setNominal(Integer nominal) {
        this.nominal = nominal;
    }

    public Integer getTipe() {
        return tipe;
    }

    public void setTipe(Integer tipe) {
        this.tipe = tipe;
    }

    public String getTipeNama() {
        return tipeNama;
    }

    public void setTipeNama(String tipeNama) {
        this.tipeNama = tipeNama;
    }

    public String getKursDari() {
        return kursDari;
    }

    public void setKursDari(String kursDari) {
        this.kursDari = kursDari;
    }

    public String getKursKe() {
        return kursKe;
    }

    public void setKursKe(String kursKe) {
        this.kursKe = kursKe;
    }

    public Boolean getAktif() {
        return aktif;
    }

    public void setAktif(Boolean aktif) {
        this.aktif = aktif;
    }
}
