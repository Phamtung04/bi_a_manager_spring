package com.eaut.quanlybia.service;

import com.eaut.quanlybia.DTO.BanDto;
import com.eaut.quanlybia.form.Ban.BanCreateForm;
import com.eaut.quanlybia.form.Ban.BanUpdateForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BanService {
    BanDto create(BanCreateForm form);
    Page<BanDto> findAll(Pageable pageable);
    BanDto update(BanUpdateForm form, Integer mb);
    void deleteByMaBan(Integer mb);
}
