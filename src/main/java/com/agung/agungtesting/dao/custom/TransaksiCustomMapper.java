package com.agung.agungtesting.dao.custom;

import com.agung.agungtesting.dto.transaksi.TransaksiItemDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TransaksiCustomMapper {
    public List<TransaksiItemDto> getAllTransactionUser(@Param("idCust") int idUser);
    public List<TransaksiItemDto> getAllTransactionByAdmin();
}
