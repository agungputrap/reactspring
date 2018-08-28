package com.agung.agungtesting.domain;

import java.io.Serializable;

public class Promo implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column promo.id
     *
     * @mbg.generated Mon Jul 02 02:49:41 ICT 2018
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column promo.nama
     *
     * @mbg.generated Mon Jul 02 02:49:41 ICT 2018
     */
    private String nama;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column promo.kurs
     *
     * @mbg.generated Mon Jul 02 02:49:41 ICT 2018
     */
    private Double kurs;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column promo.nominal
     *
     * @mbg.generated Mon Jul 02 02:49:41 ICT 2018
     */
    private Integer nominal;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column promo.tipe
     *
     * @mbg.generated Mon Jul 02 02:49:41 ICT 2018
     */
    private Integer tipe;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column promo.kurs_dari
     *
     * @mbg.generated Mon Jul 02 02:49:41 ICT 2018
     */
    private String kursDari;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column promo.kurs_ke
     *
     * @mbg.generated Mon Jul 02 02:49:41 ICT 2018
     */
    private String kursKe;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column promo.aktif
     *
     * @mbg.generated Mon Jul 02 02:49:41 ICT 2018
     */
    private Boolean aktif;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table promo
     *
     * @mbg.generated Mon Jul 02 02:49:41 ICT 2018
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column promo.id
     *
     * @return the value of promo.id
     *
     * @mbg.generated Mon Jul 02 02:49:41 ICT 2018
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column promo.id
     *
     * @param id the value for promo.id
     *
     * @mbg.generated Mon Jul 02 02:49:41 ICT 2018
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column promo.nama
     *
     * @return the value of promo.nama
     *
     * @mbg.generated Mon Jul 02 02:49:41 ICT 2018
     */
    public String getNama() {
        return nama;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column promo.nama
     *
     * @param nama the value for promo.nama
     *
     * @mbg.generated Mon Jul 02 02:49:41 ICT 2018
     */
    public void setNama(String nama) {
        this.nama = nama == null ? null : nama.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column promo.kurs
     *
     * @return the value of promo.kurs
     *
     * @mbg.generated Mon Jul 02 02:49:41 ICT 2018
     */
    public Double getKurs() {
        return kurs;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column promo.kurs
     *
     * @param kurs the value for promo.kurs
     *
     * @mbg.generated Mon Jul 02 02:49:41 ICT 2018
     */
    public void setKurs(Double kurs) {
        this.kurs = kurs;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column promo.nominal
     *
     * @return the value of promo.nominal
     *
     * @mbg.generated Mon Jul 02 02:49:41 ICT 2018
     */
    public Integer getNominal() {
        return nominal;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column promo.nominal
     *
     * @param nominal the value for promo.nominal
     *
     * @mbg.generated Mon Jul 02 02:49:41 ICT 2018
     */
    public void setNominal(Integer nominal) {
        this.nominal = nominal;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column promo.tipe
     *
     * @return the value of promo.tipe
     *
     * @mbg.generated Mon Jul 02 02:49:41 ICT 2018
     */
    public Integer getTipe() {
        return tipe;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column promo.tipe
     *
     * @param tipe the value for promo.tipe
     *
     * @mbg.generated Mon Jul 02 02:49:41 ICT 2018
     */
    public void setTipe(Integer tipe) {
        this.tipe = tipe;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column promo.kurs_dari
     *
     * @return the value of promo.kurs_dari
     *
     * @mbg.generated Mon Jul 02 02:49:41 ICT 2018
     */
    public String getKursDari() {
        return kursDari;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column promo.kurs_dari
     *
     * @param kursDari the value for promo.kurs_dari
     *
     * @mbg.generated Mon Jul 02 02:49:41 ICT 2018
     */
    public void setKursDari(String kursDari) {
        this.kursDari = kursDari == null ? null : kursDari.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column promo.kurs_ke
     *
     * @return the value of promo.kurs_ke
     *
     * @mbg.generated Mon Jul 02 02:49:41 ICT 2018
     */
    public String getKursKe() {
        return kursKe;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column promo.kurs_ke
     *
     * @param kursKe the value for promo.kurs_ke
     *
     * @mbg.generated Mon Jul 02 02:49:41 ICT 2018
     */
    public void setKursKe(String kursKe) {
        this.kursKe = kursKe == null ? null : kursKe.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column promo.aktif
     *
     * @return the value of promo.aktif
     *
     * @mbg.generated Mon Jul 02 02:49:41 ICT 2018
     */
    public Boolean getAktif() {
        return aktif;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column promo.aktif
     *
     * @param aktif the value for promo.aktif
     *
     * @mbg.generated Mon Jul 02 02:49:41 ICT 2018
     */
    public void setAktif(Boolean aktif) {
        this.aktif = aktif;
    }
}