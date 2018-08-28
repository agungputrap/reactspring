package com.agung.agungtesting.controller;

import com.agung.agungtesting.domain.Transaksi;
import com.agung.agungtesting.dto.GeneralResponse;
import com.agung.agungtesting.dto.transaksi.TransaksiHistoryResponse;
import com.agung.agungtesting.dto.transaksi.TransaksiItemDto;
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
@RequestMapping("/admin")
public class AdminController {

    Logger log = LoggerFactory.getLogger(this.getClass());
    final static String ERROR_MSG = "Failed to authenticate";

    @Autowired RestValidatorUtil rv;
    @Autowired DebugUtil d;
    @Autowired TransaksiService transaksiService;


    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @RequestMapping(value="/transactions", method = RequestMethod.GET)
    public ResponseEntity listTransactions() throws Exception {
        ResponseEntity responseEntity = null;
        try {
            List<TransaksiItemDto> res = transaksiService.getAllTransactionByAdmin();
            responseEntity =  ResponseEntity.ok(res);
        } catch (Exception e) {
            log.error("TRANSAKSI", e);
            responseEntity = ResponseEntity.badRequest().body(rv.buildError(e, ERROR_MSG));
        }

        return responseEntity;
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @RequestMapping(value="/transaction/change-status", method = RequestMethod.POST)
    public ResponseEntity changeStatusTransaksi(@RequestBody TransaksiItemDto transaksi) throws Exception {
        ResponseEntity responseEntity = null;
        try {
            transaksiService.changeTransactionStatus(transaksi);
            responseEntity =  ResponseEntity.ok(new GeneralResponse(200, "SUCCESS"));
        } catch (Exception e) {
            log.error("TRANSAKSI", e);
            responseEntity = ResponseEntity.badRequest().body(rv.buildError(e, ERROR_MSG));
        }

        return responseEntity;
    }
}
