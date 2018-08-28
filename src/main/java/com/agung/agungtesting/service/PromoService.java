package com.agung.agungtesting.service;

import com.agung.agungtesting.dao.PromoMapper;
import com.agung.agungtesting.domain.Promo;
import com.agung.agungtesting.util.DebugUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PromoService {

    @Autowired
    DebugUtil d;
    @Autowired
    PromoMapper promoMapper;

    public Promo getPromoById(int id) {
        return promoMapper.selectByPrimaryKey(id);
    }
}
