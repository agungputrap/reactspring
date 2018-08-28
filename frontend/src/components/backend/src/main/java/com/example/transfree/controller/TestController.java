package com.agung.agungtesting.controller;

import com.agung.agungtesting.util.RestValidatorUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TestController {

    Logger log = LoggerFactory.getLogger(this.getClass());

    final static String ERROR_MSG = "Failed to process";

    @Autowired
    RestValidatorUtil rv;


    @RequestMapping(value="/test-barang", method = RequestMethod.GET)
    public ResponseEntity getBarangs()
    {
        ResponseEntity  responseEntity = null;

        try {
            List<String> barangs = new ArrayList();
            barangs.add("Laptop");
            barangs.add("Colokan");
            barangs.add("Modem");
            barangs.add("Monitor");

            responseEntity =  ResponseEntity.ok(barangs);
        } catch (Exception e) {
            log.error("GET BARANG", e);
            responseEntity =  ResponseEntity.badRequest().body(rv.buildError(e, ERROR_MSG));
        }

        return responseEntity;
    }

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @RequestMapping(value="/test-barang-auth", method = RequestMethod.GET)
    public ResponseEntity getBarangsAuth()
    {
        ResponseEntity  responseEntity = null;

        try {
            List<String> barangs = new ArrayList();
            barangs.add("Sepatu");
            barangs.add("Jersey");
            barangs.add("Handuk");
            barangs.add("Tas");

            responseEntity =  ResponseEntity.ok(barangs);
        } catch (Exception e) {
            log.error("GET BARANG", e);
            responseEntity =  ResponseEntity.badRequest().body(rv.buildError(e, ERROR_MSG));
        }

        return responseEntity;
    }
}
