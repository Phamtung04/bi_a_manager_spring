package com.eaut.quanlybia.service;

import com.eaut.quanlybia.DTO.NhanVienDto;
import com.eaut.quanlybia.form.NhanVien.NhanVienCreateForm;
import com.eaut.quanlybia.form.NhanVien.NhanVienFilerForm;
import com.eaut.quanlybia.form.NhanVien.NhanVienUpdateForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface NhanVienService {
    Page<NhanVienDto> findAll(NhanVienFilerForm form, Pageable pageable);
    Page<NhanVienDto> findByTenNhanVienLike(String tenNhanVien, Pageable pageable);
    Page<NhanVienDto> findBySdtLike(String sdt, Pageable pageable);
    NhanVienDto create(NhanVienCreateForm form);
    NhanVienDto update(NhanVienUpdateForm form, Integer mnv);
    void deleteByMnv(Integer mnv);
}
