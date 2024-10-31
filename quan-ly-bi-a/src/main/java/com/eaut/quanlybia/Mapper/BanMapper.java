package com.eaut.quanlybia.Mapper;

import com.eaut.quanlybia.DTO.BanDto;
import com.eaut.quanlybia.Entity.Ban;
import com.eaut.quanlybia.form.Ban.BanCreateForm;
import com.eaut.quanlybia.form.Ban.BanUpdateForm;

public class BanMapper {
    public static Ban map(BanCreateForm form) {
        var ban = new Ban();
        ban.setLoaiBan(form.getLoaiBan());
        ban.setDonGia(form.getDonGia());
        return ban;
    }

    public static BanDto map(Ban ban) {
        var dto = new BanDto();
        dto.setMaBan(ban.getMaBan());
        dto.setLoaiBan(ban.getLoaiBan());
        dto.setTinhTrang(ban.getTinhTrang());
        dto.setDonGia(ban.getDonGia());
        return dto;
    }

    public static void map(BanUpdateForm form, Ban ban) {
        ban.setLoaiBan(form.getLoaiBan());
        ban.setDonGia(form.getDonGia());
    }
}
