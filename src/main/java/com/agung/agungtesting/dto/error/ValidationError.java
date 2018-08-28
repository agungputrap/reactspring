package com.agung.agungtesting.dto.error;

import com.google.common.collect.Maps;

import java.util.Map;

public class ValidationError {
    private Map<String, Object> errors = Maps.newHashMap();

    public ValidationError() {
    }

    public void addFieldError(String path, String message) {
        errors.put(path, message);
    }

    public Map<String, Object> getErrors() {
        return errors;
    }
}
