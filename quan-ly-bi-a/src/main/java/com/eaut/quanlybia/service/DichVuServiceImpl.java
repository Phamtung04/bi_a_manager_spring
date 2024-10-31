package com.eaut.quanlybia.service;

import com.eaut.quanlybia.DTO.DichVuDto;
import com.eaut.quanlybia.Mapper.DichVuMapper;
import com.eaut.quanlybia.form.dichvu.DichVuCreateForm;
import com.eaut.quanlybia.form.dichvu.DichVuFilerForm;
import com.eaut.quanlybia.form.dichvu.DichVuUpdateForm;
import com.eaut.quanlybia.repository.DichVuRepository;
import com.eaut.quanlybia.service.DichVuService;
import com.eaut.quanlybia.specification.DichVuSpecification;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DichVuServiceImpl implements DichVuService {
    private DichVuRepository dichVuRepository;

    @Override
    public DichVuDto update(DichVuUpdateForm form, Integer MDV) {
        var dichVu = dichVuRepository.findByMdv(MDV);
        DichVuMapper.map(form, dichVu);
        var saveDichVu = dichVuRepository.save(dichVu);
        return DichVuMapper.map(saveDichVu);
    }

    @Override
    public DichVuDto create(DichVuCreateForm form) {
        var dichVu = DichVuMapper.map(form);
        var saveDichVu = dichVuRepository.save(dichVu);
        return DichVuMapper.map(saveDichVu);
    }

    @Override
    public void deleteByMdv(Integer MDV) {
        dichVuRepository.deleteById(MDV);
    }

    @Override
    public Page<DichVuDto> findAll(DichVuFilerForm form, Pageable pageable) {
        var spec = DichVuSpecification.buildSpec(form);
        return dichVuRepository.findAll(spec, pageable).map(DichVuMapper :: map);
    }

    @Override
    public Page<DichVuDto> findByTenDichVuLike(String tenDV, Pageable pageable) {
        return dichVuRepository.findByTenDichVuLike(tenDV, pageable).map(DichVuMapper :: map);
    }
}
