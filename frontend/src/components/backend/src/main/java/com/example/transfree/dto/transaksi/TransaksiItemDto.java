package com.agung.agungtesting.dto.transaksi;

import java.math.BigDecimal;
import java.util.Date;

public class TransaksiItemDto {
    private Integer id;
    private Date waktuTransaksi;
    private String waktuTransaksiStr;
    private Long nominal;
    private String kursDari;
    private String kursKe;
    private String namaPenerima;
    private String namaPengirim;
    private Integer idCustomerPenerima;
    private Long nominalIdr;
    private String status;
    private Double kurs;
    private Double kursIdr;
    private Integer promoId;
    private String promoNama;
    private Double promoKurs;
    private Integer promoNominal;
    private String promoTipe;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getWaktuTransaksi() {
        return waktuTransaksi;
    }

    public void setWaktuTransaksi(Date waktuTransaksi) {
        this.waktuTransaksi = waktuTransaksi;
    }

    public String getWaktuTransaksiStr() {
        return waktuTransaksiStr;
    }

    public void setWaktuTransaksiStr(String waktuTransaksiStr) {
        this.waktuTransaksiStr = waktuTransaksiStr;
    }

    public Long getNominal() {
        return nominal;
    }

    public void setNominal(Long nominal) {
        this.nominal = nominal;
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

    public String getNamaPenerima() {
        return namaPenerima;
    }

    public void setNamaPenerima(String namaPenerima) {
        this.namaPenerima = namaPenerima;
    }

    public String getNamaPengirim() {
        return namaPengirim;
    }

    public void setNamaPengirim(String namaPengirim) {
        this.namaPengirim = namaPengirim;
    }

    public Integer getIdCustomerPenerima() {
        return idCustomerPenerima;
    }

    public void setIdCustomerPenerima(Integer idCustomerPenerima) {
        this.idCustomerPenerima = idCustomerPenerima;
    }

    public Long getNominalIdr() {
        return nominalIdr;
    }

    public void setNominalIdr(Long nominalIdr) {
        this.nominalIdr = nominalIdr;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getKurs() {
        return kurs;
    }

    public void setKurs(Double kurs) {
        this.kurs = kurs;
    }

    public Double getKursIdr() {
        return kursIdr;
    }

    public void setKursIdr(Double kursIdr) {
        this.kursIdr = kursIdr;
    }

    public Integer getPromoId() {
        return promoId;
    }

    public void setPromoId(Integer promoId) {
        this.promoId = promoId;
    }

    public String getPromoNama() {
        return promoNama;
    }

    public void setPromoNama(String promoNama) {
        this.promoNama = promoNama;
    }

    public Double getPromoKurs() {
        return promoKurs;
    }

    public void setPromoKurs(Double promoKurs) {
        this.promoKurs = promoKurs;
    }

    public Integer getPromoNominal() {
        return promoNominal;
    }

    public void setPromoNominal(Integer promoNominal) {
        this.promoNominal = promoNominal;
    }

    public String getPromoTipe() {
        return promoTipe;
    }

    public void setPromoTipe(String promoTipe) {
        this.promoTipe = promoTipe;
    }
}
