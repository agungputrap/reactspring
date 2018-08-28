package com.agung.agungtesting.auth;

public class AppCredentials {
    private String kode;
    private String apiKey;

    public AppCredentials(String kode, String apiKey) {
        this.kode = kode;
        this.apiKey = apiKey;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }
}
