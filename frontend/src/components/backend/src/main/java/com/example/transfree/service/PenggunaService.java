package com.agung.agungtesting.service;

import com.agung.agungtesting.dao.CustomerMapper;
import com.agung.agungtesting.dao.PenggunaMapper;
import com.agung.agungtesting.dao.PenggunaPeranMapper;
import com.agung.agungtesting.domain.*;
import com.agung.agungtesting.dto.auth.RegisterRequest;
import com.agung.agungtesting.dto.pengguna.PenggunaCustom;
import com.agung.agungtesting.util.DebugUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PenggunaService {

    BCryptPasswordEncoder passwordEncoder =  new BCryptPasswordEncoder();
    @Autowired PenggunaMapper penggunaMapper;
    @Autowired CustomerMapper customerMapper;
    @Autowired PenggunaPeranMapper penggunaPeranMapper;
    @Autowired RoleService roleService;
    @Autowired DebugUtil d;

    public Pengguna getPenggunaByUsername(String username) {
        PenggunaExample example = new PenggunaExample();
        example.createCriteria()
                .andUsernameEqualTo(username);

        List<Pengguna> list = penggunaMapper.selectByExample(example);

        return list.isEmpty() ? null : list.get(0);
    }

    public Pengguna getPenggunaByUsernameOrEmail(String usernameOrEmail) {
        Pengguna userweb = this.getPenggunaByUsername(usernameOrEmail);
        if (userweb == null) {
            Pengguna pengguna = this.getPenggunaByEmail(usernameOrEmail);
            if (pengguna != null) {
                userweb = pengguna;
            }
        }

        return userweb;
    }

    public Pengguna getPenggunaByEmail(String email) {
        PenggunaExample example = new PenggunaExample();
        example.createCriteria().andEmailEqualTo(email);

        List<Pengguna> list = penggunaMapper.selectByExample(example);

        return list.isEmpty() ? null : list.get(0);
    }

    public Pengguna addPenggunaByRequest(RegisterRequest registerRequest) {
        Pengguna pengguna = new Pengguna();
        pengguna.setNama(registerRequest.getFullname());
        pengguna.setEmail(registerRequest.getEmail());
        pengguna.setUsername(registerRequest.getUsername());
        pengguna.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        pengguna.setKtpId(registerRequest.getKtpId());
        pengguna.setTanggalLahir(registerRequest.getTanggalLahir());
        pengguna.setKtpLokasi(registerRequest.getKtpLokasi());
        pengguna.setCreatedAt(new Date());

        penggunaMapper.insertSelective(pengguna);

        PenggunaPeran pp = new PenggunaPeran();
        pp.setIdPengguna(pengguna.getId());
        pp.setIdPeran((long)1);

        penggunaPeranMapper.insertSelective(pp);

        return pengguna;
    }

    public PenggunaCustom getPenggunaCustomByUsernameOrEmail(String usernameOrEmail) {
        System.out.println("username:" + usernameOrEmail);
        PenggunaCustom res = new PenggunaCustom();
        Pengguna pengguna = this.getPenggunaByEmail(usernameOrEmail);
        if(pengguna == null) {
            pengguna = this.getPenggunaByUsername(usernameOrEmail);
        }
        System.out.println("pengguna:" + d.toString(pengguna));
        List<Peran> listIdRole = roleService.getAllPeranByIdPengguna(pengguna.getId());
        /*CustomerExample cEx = new CustomerExample();
        cEx.createCriteria().andIdPenggunaEqualTo(pengguna.getId().intValue());
        List<Customer> lsCustomer = customerMapper.selectByExample(cEx);*/

        res.setId(pengguna.getId().intValue());
        res.setNama(pengguna.getNama());
        res.setEmail(pengguna.getEmail());
        res.setTanggalLahir(pengguna.getTanggalLahir());
        res.setUsername(pengguna.getUsername());
        res.setIdPeran(listIdRole.get(0).getId().intValue());
        res.setPeran(listIdRole.get(0).getNama());
        /*res.setIdCustomer(lsCustomer.get(0).getId());
        res.setNamaBank(lsCustomer.get(0).getBank());
        res.setRekening(lsCustomer.get(0).getRekening());*/

        return res;
    }
}
