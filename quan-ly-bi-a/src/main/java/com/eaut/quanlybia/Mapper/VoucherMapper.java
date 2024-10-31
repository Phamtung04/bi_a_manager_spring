package com.eaut.quanlybia.Mapper;

import com.eaut.quanlybia.DTO.VoucherDto;
import com.eaut.quanlybia.Entity.KhachHang;
import com.eaut.quanlybia.Entity.Voucher;
import com.eaut.quanlybia.form.voucher.VoucherCreatedForm;
import com.eaut.quanlybia.form.voucher.VoucherUpdateForm;

public class VoucherMapper {
    public static Voucher map(VoucherCreatedForm form) {
        var voucher = new Voucher();
        voucher.setTenVoucher(form.getTenVoucher());
        voucher.setGiaTri(form.getGiaTri());
        return voucher;
    }

    public static VoucherDto map(Voucher voucher) {
        var dto = new VoucherDto();
        dto.setMVC(voucher.getMVC());
        dto.setTenVoucher(voucher.getTenVoucher());
        dto.setGiaiTri(voucher.getGiaTri());
        dto.setHang(voucher.getHang());
        return dto;
    }
    public static void map(VoucherUpdateForm form, Voucher voucher) {
        voucher.setTenVoucher(form.getTenVoucher());
        voucher.setGiaTri(form.getGiaTri());
    }
}
