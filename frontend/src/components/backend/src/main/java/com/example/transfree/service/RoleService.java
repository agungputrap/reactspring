package com.agung.agungtesting.service;

import com.agung.agungtesting.dao.PenggunaPeranMapper;
import com.agung.agungtesting.dao.PeranMapper;
import com.agung.agungtesting.domain.PenggunaPeran;
import com.agung.agungtesting.domain.PenggunaPeranExample;
import com.agung.agungtesting.domain.Peran;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleService {

    @Autowired PenggunaPeranMapper penggunaPeranMapper;
    @Autowired PeranMapper peranMapper;

    public List<Long> getListIdRoleByIdUser(Long idUser) {
        List<Long> result = new ArrayList();
        PenggunaPeranExample ex = new PenggunaPeranExample();
        ex.createCriteria().andIdPenggunaEqualTo(idUser);

        List<PenggunaPeran> lsPenggunPeran = penggunaPeranMapper.selectByExample(ex);
        for(PenggunaPeran pp : lsPenggunPeran) {
            result.add(pp.getIdPeran());
        }
        return result;
    }

    public List<String> getListPeranByIdPengguna(Long idUser) {
        List<String> result = new ArrayList();
        PenggunaPeranExample ex = new PenggunaPeranExample();
        ex.createCriteria().andIdPenggunaEqualTo(idUser);

        List<PenggunaPeran> lsPenggunPeran = penggunaPeranMapper.selectByExample(ex);
        for(PenggunaPeran pp : lsPenggunPeran) {
            Peran peran = peranMapper.selectByPrimaryKey(pp.getIdPeran());
            result.add(peran.getNama());
        }
        return result;
    }

    public List<Peran> getAllPeranByIdPengguna(Long idUser) {
        List<Peran> result = new ArrayList();
        PenggunaPeranExample ex = new PenggunaPeranExample();
        ex.createCriteria().andIdPenggunaEqualTo(idUser);

        List<PenggunaPeran> lsPenggunPeran = penggunaPeranMapper.selectByExample(ex);
        for(PenggunaPeran pp : lsPenggunPeran) {
            Peran peran = peranMapper.selectByPrimaryKey(pp.getIdPeran());
            result.add(peran);
        }
        return result;
    }
}
