package com.eaut.quanlybia.Mapper;

import com.eaut.quanlybia.DTO.DatBanDto;
import com.eaut.quanlybia.Entity.DatBan;
import com.eaut.quanlybia.form.datban.DatBanCreateForm;
import com.eaut.quanlybia.form.datban.DatBanUpdateForm;

public class DatBanMapper {
    public static DatBan map(DatBanCreateForm form) {
        var datBan = new DatBan();
        datBan.setTienCoc(form.getTienCoc());
        return datBan;
    }

    public static DatBanDto map(DatBan datBan) {
        var dto = new DatBanDto();
        dto.setMkh(datBan.getKhachHang().getMkh());
        dto.setTienCoc(datBan.getTienCoc());
        dto.setGioBatDau(datBan.getGioBatDau());
        dto.setLoaiBan(datBan.getBan().getLoaiBan());
        dto.setTinhTrang(datBan.getBan().getTinhTrang());
        dto.setDonGia(datBan.getBan().getDonGia());
        return dto;
    }



}
