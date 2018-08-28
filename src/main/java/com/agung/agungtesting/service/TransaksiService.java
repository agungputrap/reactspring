package com.agung.agungtesting.service;

import com.agung.agungtesting.auth.AuthService;
import com.agung.agungtesting.dao.CustomerMapper;
import com.agung.agungtesting.dao.PromoMapper;
import com.agung.agungtesting.dao.TransaksiMapper;
import com.agung.agungtesting.dao.custom.TransaksiCustomMapper;
import com.agung.agungtesting.domain.*;
import com.agung.agungtesting.dto.pengguna.PenggunaCustom;
import com.agung.agungtesting.dto.transaksi.*;
import com.agung.agungtesting.util.DateUtil;
import com.agung.agungtesting.util.DebugUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TransaksiService {

    @Autowired
    DebugUtil d;
    @Autowired
    TransaksiMapper transaksiMapper;
    @Autowired
    TransaksiCustomMapper transaksiCustomMapper;
    @Autowired
    CustomerMapper customerMapper;
    @Autowired
    AuthService authService;
    @Autowired
    PromoMapper promoMapper;

    public TransaksiHistoryResponse getAllTransactionUser(int idUser) {
        TransaksiHistoryResponse res = new TransaksiHistoryResponse();
        long totalTransaksiIdr = 0;
        List<TransaksiItemDto> lsTransaksi = transaksiCustomMapper.getAllTransactionUser(idUser);
        for(TransaksiItemDto t : lsTransaksi) {
            long idr = Math.round(t.getKursIdr() * t.getNominal());
            totalTransaksiIdr += idr;
            t.setNominalIdr(idr);

            t.setWaktuTransaksiStr(DateUtil.dateToStringTextIndo(t.getWaktuTransaksi()));
        }
        System.out.println("TRANS : " + d.toString(lsTransaksi));

        res.setIdPengguna(idUser);
        res.setTransaksi(lsTransaksi);
        res.setTotalTransaksiIdr(totalTransaksiIdr);

        return res;
    }

    public void addNewRecipient(RecipientRequest request) {
        PenggunaCustom pengguna = authService.getCurrentUserweb();
        Customer customer = new Customer();
        customer.setNama(request.getFullname());
        customer.setRekening(request.getAccountNumber());
        customer.setIbanCode(request.getIban());
        customer.setBank(request.getBank());
        customer.setIdPengguna(pengguna.getId());

        customerMapper.insertSelective(customer);
    }

    public List<RecipientItem> getAllRecipientPengguna(int idPengguna) {
        List<RecipientItem> res = new ArrayList();
        CustomerExample cEx = new CustomerExample();
        cEx.createCriteria().andIdPenggunaEqualTo(idPengguna);
        List<Customer> customers = customerMapper.selectByExample(cEx);

        for(Customer c : customers) {
            String text = c.getNama() + " - " + c.getBank() + " -   " + c.getRekening();
            res.add(new RecipientItem(c.getNama(), c.getBank(), c.getRekening(), c.getIbanCode(), text, c.getId()));
        }

        return res;
    }

    public void addNewTransaction(TransaksiRequest request) {
        PenggunaCustom pengguna = authService.getCurrentUserweb();
        Transaksi trans = new Transaksi();
        trans.setIdPengirim(pengguna.getId());
        trans.setNominal(request.getFrom().longValue());
        trans.setKursDari(request.getFromCode());
        trans.setKursKe(request.getToCode());
        trans.setIdPenerima(request.getRecipient());
        trans.setWaktuTransaksi(new Date());
        trans.setStatus("SUBMIT");
        trans.setKurs(request.getKurs().doubleValue());
        trans.setKursIdr(request.getKursIdr().doubleValue());
        trans.setPromoId(request.getPromoId());

        transaksiMapper.insertSelective(trans);
    }

    public List<TransaksiItemDto> getAllTransactionByAdmin() {
        List<TransaksiItemDto> res = transaksiCustomMapper.getAllTransactionByAdmin();
        for(TransaksiItemDto dto : res) {
            dto.setWaktuTransaksiStr(DateUtil.dateToStringTextIndo(dto.getWaktuTransaksi()));
            dto.setNominalIdr((long) (dto.getNominal() * dto.getKursIdr()));
        }
        return res;
    }

    public Transaksi changeTransactionStatus(TransaksiItemDto dto) {
        Transaksi item = transaksiMapper.selectByPrimaryKey(dto.getId());
        item.setStatus(dto.getStatus());

        transaksiMapper.updateByPrimaryKeySelective(item);

        return item;
    }

    public List<PromoItem> getAllActivePromo() {
        PromoExample pEx = new PromoExample();
        pEx.createCriteria().andAktifEqualTo(true);
        List<PromoItem> res = new ArrayList();
        List<Promo> ls = promoMapper.selectByExample(pEx);
        for(Promo p : ls) {
            PromoItem promoItem = new PromoItem();
            promoItem.setId(p.getId());
            promoItem.setNama(p.getNama());
            promoItem.setKurs(p.getKurs());
            promoItem.setNominal(p.getNominal());
            promoItem.setTipe(p.getTipe());
            promoItem.setKursDari(p.getKursDari());
            promoItem.setKursKe(p.getKursKe());
            promoItem.setAktif(p.getAktif());
            promoItem.setTipeNama(p.getTipe() == 1?"Special rate / Discount" : "Fast transfer");

            res.add(promoItem);
        }

        return res;
    }
}
