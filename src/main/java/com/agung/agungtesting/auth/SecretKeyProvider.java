package com.agung.agungtesting.auth;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;

@Component
public class SecretKeyProvider {

    @Value("${app.jwtSecret}") String jwtKey;

    public byte[] getKey() throws URISyntaxException, IOException {
        InputStream in = getClass().getResourceAsStream("/jwt.key");
        byte[] key = IOUtils.toByteArray(in);
        //byte[] key = jwtKey.getBytes();
        return key;
    }
}
