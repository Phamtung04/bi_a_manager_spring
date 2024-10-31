package com.eaut.quanlybia.service;

import com.eaut.quanlybia.DTO.VoucherDto;
import com.eaut.quanlybia.Entity.KhachHang;
import com.eaut.quanlybia.form.khachhang.KhachHangFilerForm;
import com.eaut.quanlybia.form.voucher.VoucherCreatedForm;
import com.eaut.quanlybia.form.voucher.VoucherFilerForm;
import com.eaut.quanlybia.form.voucher.VoucherUpdateForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface VoucherService {
    List<VoucherDto> create(VoucherCreatedForm form, Integer hang);
    Page<VoucherDto> findAll(VoucherFilerForm form, Pageable pageable);

    Page<VoucherDto> findByTenVoucherLike(String tenVC, Pageable pageable);

    Page<VoucherDto> findByHang(Integer hang, Pageable pageable);

    List<VoucherDto> update(VoucherUpdateForm form, Integer hang);

    void deleteByHang(Integer hang);
}
