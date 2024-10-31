package com.eaut.quanlybia.service;

import com.eaut.quanlybia.DTO.DatBanDto;
import com.eaut.quanlybia.Entity.DatBan;
import com.eaut.quanlybia.form.datban.DatBanCreateForm;
import com.eaut.quanlybia.form.datban.DatBanUpdateForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DatBanService {
    DatBanDto create(DatBanCreateForm form);
    Page<DatBanDto> findAll(Pageable pageable);

    DatBanDto update(DatBanUpdateForm form, Integer mdb);

    void deleteByMdb(Integer mdb);

}
