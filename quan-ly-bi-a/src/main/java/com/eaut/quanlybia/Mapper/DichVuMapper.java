package com.eaut.quanlybia.Mapper;

import com.eaut.quanlybia.DTO.DichVuDto;
import com.eaut.quanlybia.Entity.DichVu;
import com.eaut.quanlybia.form.dichvu.DichVuCreateForm;
import com.eaut.quanlybia.form.dichvu.DichVuUpdateForm;

public class DichVuMapper {
    public static DichVu map(DichVuCreateForm form) {
        var dichVu = new DichVu();
        dichVu.setTenDichVu(form.getTenDichVu());
        dichVu.setDonGia(form.getDonGia());
        return dichVu;
    }

    public static DichVuDto map(DichVu dichVu) {
        var dto = new DichVuDto();
        dto.setTenDichVu(dichVu.getTenDichVu());
        dto.setDonGia(dichVu.getDonGia());
        return dto;
    }

    public static void map(DichVuUpdateForm form, DichVu dichVu) {
        dichVu.setTenDichVu(form.getTenDichVu());
        dichVu.setDonGia(form.getDonGia());
    }
}
