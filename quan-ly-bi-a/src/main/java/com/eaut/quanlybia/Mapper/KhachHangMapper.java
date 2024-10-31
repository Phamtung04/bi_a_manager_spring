package com.eaut.quanlybia.Mapper;

import com.eaut.quanlybia.DTO.khachHangDto;
import com.eaut.quanlybia.Entity.KhachHang;
import com.eaut.quanlybia.form.khachhang.KhachHangCreateForm;
import com.eaut.quanlybia.form.khachhang.KhachHangUpdateForm;

public class KhachHangMapper {


    public static KhachHang map(KhachHangCreateForm form) {
        var khachHang = new KhachHang();
        khachHang.setTenKhachHang(form.getTenKhachHang());
        khachHang.setSdt(form.getSdt());
        khachHang.setGioiTinh(form.getGioiTinh());
        khachHang.setMatKhau(form.getMatKhau());
        khachHang.setHang(form.getHang());
        return khachHang;
    }

    public static khachHangDto map(KhachHang khachHang) {
        var dto = new khachHangDto();
        dto.setMkh(khachHang.getMkh());
        dto.setTenKhachHang(khachHang.getTenKhachHang());
        dto.setSdt(khachHang.getSdt());
        dto.setGioiTinh(khachHang.getGioiTinh());
        dto.setHang(khachHang.getHang());
        return dto.withSelfRel();
    }

    public static void map(KhachHangUpdateForm form, KhachHang khachHang) {
        khachHang.setTenKhachHang(form.getTenKhachHang());
        khachHang.setSdt(form.getSDT());
        khachHang.setGioiTinh(form.getGioiTinh());
        khachHang.setMatKhau(form.getMatKhau());
        khachHang.setHang(form.getHang());
    }
}

