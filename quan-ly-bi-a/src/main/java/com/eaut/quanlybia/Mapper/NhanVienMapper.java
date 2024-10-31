package com.eaut.quanlybia.Mapper;

import com.eaut.quanlybia.DTO.NhanVienDto;
import com.eaut.quanlybia.Entity.NhanVien;
import com.eaut.quanlybia.form.NhanVien.NhanVienCreateForm;
import com.eaut.quanlybia.form.NhanVien.NhanVienUpdateForm;

public class NhanVienMapper {
    public static NhanVien map(NhanVienCreateForm form) {
        var nhanVien = new NhanVien();
        nhanVien.setTenNhanVien(form.getTenNhanVien());
        nhanVien.setSdt(form.getSdt());
        nhanVien.setNamSinh(form.getNamSinh());
        nhanVien.setCaLamViec(form.getCaLamViec());
        nhanVien.setGioiTinh(form.getGioiTinh());
        return nhanVien;
    }

    public static NhanVienDto map(NhanVien nhanVien) {
        var dto = new NhanVienDto();
        dto.setMnv(nhanVien.getMnv());
        dto.setTenNhanVien(nhanVien.getTenNhanVien());
        dto.setSdt(nhanVien.getSdt());
        dto.setNamSinh(nhanVien.getNamSinh());
        dto.setCaLamViec(nhanVien.getCaLamViec());
        dto.setGioiTinh(nhanVien.getGioiTinh());
        return dto;
    }

    public static void map(NhanVienUpdateForm form, NhanVien nhanVien) {
        nhanVien.setTenNhanVien(form.getTenNhanVien());
        nhanVien.setNamSinh(form.getNamSinh());
        nhanVien.setSdt(form.getSdt());
        nhanVien.setCaLamViec(form.getCaLamViec());
        nhanVien.setGioiTinh(form.getGioiTinh());
    }
}
