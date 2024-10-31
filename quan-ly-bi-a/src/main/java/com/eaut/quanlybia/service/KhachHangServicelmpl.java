package com.eaut.quanlybia.service;

import com.eaut.quanlybia.DTO.khachHangDto;
import com.eaut.quanlybia.Mapper.KhachHangMapper;
import com.eaut.quanlybia.form.khachhang.KhachHangCreateForm;
import com.eaut.quanlybia.form.khachhang.KhachHangFilerForm;
import com.eaut.quanlybia.form.khachhang.KhachHangUpdateForm;
import com.eaut.quanlybia.repository.KhachHangRepository;
import com.eaut.quanlybia.specification.KhachHangSpecification;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class KhachHangServicelmpl implements KhachHangService {
    private KhachHangRepository khachHangRepository;


    @Override
    public Page<khachHangDto> findAll(KhachHangFilerForm form, Pageable pageable) {
        var spec = KhachHangSpecification.buildSpec(form);
        return khachHangRepository.findAll(spec, pageable).map(KhachHangMapper :: map);
    }

    @Override
    public khachHangDto findByMkh(Integer MKH) {
        var khachHang = khachHangRepository.findById(MKH).get();
        return KhachHangMapper.map(khachHang);
    }

    @Override
    public khachHangDto create(KhachHangCreateForm form) {
        var khachHang = KhachHangMapper.map(form);
        var saveKhachHang = khachHangRepository.save(khachHang);
        return KhachHangMapper.map(saveKhachHang);
    }

    @Override
    public khachHangDto update(KhachHangUpdateForm form, Integer MKH) {
        var khachHang = khachHangRepository.findById(MKH).get();
        KhachHangMapper.map(form, khachHang);
        var saveKhachHang = khachHangRepository.save(khachHang);
        return KhachHangMapper.map(saveKhachHang);
    }

    @Override
    public void deleteByMkh(Integer MKH) {
        khachHangRepository.deleteById(MKH);
    }
}
