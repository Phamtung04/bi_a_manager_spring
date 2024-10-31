package com.eaut.quanlybia.service;

import com.eaut.quanlybia.DTO.DichVuDto;
import com.eaut.quanlybia.form.dichvu.DichVuCreateForm;
import com.eaut.quanlybia.form.dichvu.DichVuFilerForm;
import com.eaut.quanlybia.form.dichvu.DichVuUpdateForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DichVuService {
    DichVuDto create(DichVuCreateForm form);
    Page<DichVuDto> findAll(DichVuFilerForm form, Pageable pageable);
    Page<DichVuDto> findByTenDichVuLike(String tenDV, Pageable pageable);

    DichVuDto update(DichVuUpdateForm form, Integer MDV);

    void deleteByMdv(Integer MDV);

}
