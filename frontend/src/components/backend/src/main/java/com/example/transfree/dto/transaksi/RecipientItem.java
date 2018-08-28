package com.agung.agungtesting.dto.transaksi;

public class RecipientItem {
    private String fullname;
    private String bank;
    private String accountNumber;
    private String iban;
    private String text;
    private Integer value;

    public RecipientItem(String fullname, String bank, String accountNumber, String iban, String text, Integer value) {
        this.fullname = fullname;
        this.bank = bank;
        this.accountNumber = accountNumber;
        this.iban = iban;
        this.text = text;
        this.value = value;
    }

    public RecipientItem() {
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
