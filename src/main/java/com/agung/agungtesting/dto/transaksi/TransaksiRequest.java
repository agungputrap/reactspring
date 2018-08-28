package com.agung.agungtesting.dto.transaksi;

public class TransaksiRequest {
    private Float from;
    private Float to;
    private String fromCode;
    private String toCode;
    private Integer recipient;
    private Float kurs;
    private Float kursIdr;
    private Integer promoId;

    public Float getFrom() {
        return from;
    }

    public void setFrom(Float from) {
        this.from = from;
    }

    public Float getTo() {
        return to;
    }

    public void setTo(Float to) {
        this.to = to;
    }

    public String getFromCode() {
        return fromCode;
    }

    public void setFromCode(String fromCode) {
        this.fromCode = fromCode;
    }

    public String getToCode() {
        return toCode;
    }

    public void setToCode(String toCode) {
        this.toCode = toCode;
    }

    public Integer getRecipient() {
        return recipient;
    }

    public void setRecipient(Integer recipient) {
        this.recipient = recipient;
    }

    public Float getKurs() {
        return kurs;
    }

    public void setKurs(Float kurs) {
        this.kurs = kurs;
    }

    public Float getKursIdr() {
        return kursIdr;
    }

    public void setKursIdr(Float kursIdr) {
        this.kursIdr = kursIdr;
    }

    public Integer getPromoId() {
        return promoId;
    }

    public void setPromoId(Integer promoId) {
        this.promoId = promoId;
    }
}
