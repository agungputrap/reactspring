package com.agung.agungtesting.dto;

public class GeneralResponse {
    public int code;
    public String response;

    public GeneralResponse(int code, String response) {
        this.code = code;
        this.response = response;
    }

    public GeneralResponse() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
