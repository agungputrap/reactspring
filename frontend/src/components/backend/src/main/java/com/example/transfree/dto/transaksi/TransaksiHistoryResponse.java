package com.agung.agungtesting.dto.transaksi;

import com.agung.agungtesting.domain.Transaksi;

import java.util.List;

public class TransaksiHistoryResponse {
    private Integer idPengguna;
    private Long totalTransaksiIdr;
    private Long totalTransaksiGbp;
    private List<TransaksiItemDto> transaksi;

    public Integer getIdPengguna() {
        return idPengguna;
    }

    public void setIdPengguna(Integer idPengguna) {
        this.idPengguna = idPengguna;
    }

    public Long getTotalTransaksiIdr() {
        return totalTransaksiIdr;
    }

    public void setTotalTransaksiIdr(Long totalTransaksiIdr) {
        this.totalTransaksiIdr = totalTransaksiIdr;
    }

    public Long getTotalTransaksiGbp() {
        return totalTransaksiGbp;
    }

    public void setTotalTransaksiGbp(Long totalTransaksiGbp) {
        this.totalTransaksiGbp = totalTransaksiGbp;
    }

    public List<TransaksiItemDto> getTransaksi() {
        return transaksi;
    }

    public void setTransaksi(List<TransaksiItemDto> transaksi) {
        this.transaksi = transaksi;
    }
}
