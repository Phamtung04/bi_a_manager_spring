package com.eaut.quanlybia.service;

import com.eaut.quanlybia.DTO.khachHangDto;
import com.eaut.quanlybia.form.khachhang.KhachHangCreateForm;
import com.eaut.quanlybia.form.khachhang.KhachHangFilerForm;
import com.eaut.quanlybia.form.khachhang.KhachHangUpdateForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface KhachHangService {
    Page<khachHangDto> findAll(KhachHangFilerForm form, Pageable pageable);
    khachHangDto findByMkh(Integer id);
    khachHangDto create(KhachHangCreateForm form);
    khachHangDto update(KhachHangUpdateForm form, Integer MKH);
    void deleteByMkh(Integer id);

}
