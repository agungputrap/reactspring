package com.agung.agungtesting.controller;

import com.agung.agungtesting.domain.Promo;
import com.agung.agungtesting.dto.transaksi.*;
import com.agung.agungtesting.service.PromoService;
import com.agung.agungtesting.service.TransaksiService;
import com.agung.agungtesting.util.DebugUtil;
import com.agung.agungtesting.util.RestValidatorUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/transaction")
public class TransactionController {

    Logger log = LoggerFactory.getLogger(this.getClass());
    final static String ERROR_MSG = "Failed to authenticate";

    @Autowired
    RestValidatorUtil rv;
    @Autowired
    DebugUtil d;
    @Autowired
    TransaksiService transaksiService;
    @Autowired
    PromoService promoService;

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @RequestMapping(value="/transactions/{idCust}", method = RequestMethod.GET)
    public ResponseEntity CurrentUser(@PathVariable int idCust) throws Exception {
        ResponseEntity responseEntity = null;
        try {

            TransaksiHistoryResponse res = transaksiService.getAllTransactionUser(idCust);
            responseEntity =  ResponseEntity.ok(res);
        } catch (Exception e) {
            log.error("TRANSAKSI", e);
            responseEntity = ResponseEntity.badRequest().body(rv.buildError(e, ERROR_MSG));
        }

        return responseEntity;
    }

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @RequestMapping(value="/recipient/add", method = RequestMethod.POST)
    public ResponseEntity addRecipient(@RequestBody RecipientRequest request) throws Exception {
        ResponseEntity responseEntity = null;
        try {
            transaksiService.addNewRecipient(request);
            responseEntity = ResponseEntity.ok().build();
        } catch (Exception e) {
            log.error("TRANSAKSI", e);
            responseEntity = ResponseEntity.badRequest().body(rv.buildError(e, ERROR_MSG));
        }

        return responseEntity;
    }

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @RequestMapping(value="/recipient/all/{idPengguna}", method = RequestMethod.GET)
    public ResponseEntity getAllRecipient(@PathVariable int idPengguna) throws Exception {
        ResponseEntity responseEntity = null;
        try {

            List<RecipientItem> recipientItems = transaksiService.getAllRecipientPengguna(idPengguna);
            responseEntity =  ResponseEntity.ok(recipientItems);
        } catch (Exception e) {
            log.error("TRANSAKSI", e);
            responseEntity = ResponseEntity.badRequest().body(rv.buildError(e, ERROR_MSG));
        }

        return responseEntity;
    }

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @RequestMapping(value="/transactions/send", method = RequestMethod.POST)
    public ResponseEntity sendMoney(@RequestBody TransaksiRequest request) throws Exception {
        ResponseEntity responseEntity = null;
        try {
            transaksiService.addNewTransaction(request);
            responseEntity = ResponseEntity.ok().build();
        } catch (Exception e) {
            log.error("TRANSAKSI", e);
            responseEntity = ResponseEntity.badRequest().body(rv.buildError(e, ERROR_MSG));
        }

        return responseEntity;
    }

    @RequestMapping(value="/promos/all", method = RequestMethod.GET)
    public ResponseEntity allActivePromos() throws Exception {
        ResponseEntity responseEntity = null;
        try {
            List<PromoItem> promos = transaksiService.getAllActivePromo();
            responseEntity = ResponseEntity.ok(promos);
        } catch (Exception e) {
            log.error("TRANSAKSI", e);
            responseEntity = ResponseEntity.badRequest().body(rv.buildError(e, ERROR_MSG));
        }

        return responseEntity;
    }

    @RequestMapping(value="/promo/buy", method = RequestMethod.POST)
    public ResponseEntity buyPromo(@RequestBody Integer id) throws Exception {
        ResponseEntity responseEntity = null;
        try {
            Promo promo = promoService.getPromoById(id);
            responseEntity = ResponseEntity.ok(promo);
        } catch (Exception e) {
            log.error("TRANSAKSI", e);
            responseEntity = ResponseEntity.badRequest().body(rv.buildError(e, ERROR_MSG));
        }

        return responseEntity;
    }
}
