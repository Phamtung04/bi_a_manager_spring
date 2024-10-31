package com.eaut.quanlybia.Mapper;

import com.eaut.quanlybia.DTO.HoaDonDto;
import com.eaut.quanlybia.Entity.HoaDon;
import com.eaut.quanlybia.form.hoadon.HoaDonCreateForm;

public class HoaDonMapper {
    public static HoaDon map(HoaDonCreateForm form) {
        var hoaDon = new HoaDon();
        return hoaDon;
    }

    public static HoaDonDto map(HoaDon hoaDon) {
        var dto = new HoaDonDto();
        dto.setMaHoaDon(hoaDon.getMaHoaDon());
        dto.setMnv(hoaDon.getNhanVien().getMnv());
        dto.setGioBatDau(hoaDon.getDatBan().getGioBatDau());
        dto.setGioKetThuc(hoaDon.getGioKetThuc());
        dto.setDichVus(hoaDon.getDichVus());
        dto.setTongtien(hoaDon.getTongtien());
        return dto;
    }
}
