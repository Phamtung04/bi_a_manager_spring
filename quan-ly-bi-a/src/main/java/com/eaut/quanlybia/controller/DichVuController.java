package com.eaut.quanlybia.controller;

import com.eaut.quanlybia.DTO.DichVuDto;
import com.eaut.quanlybia.form.dichvu.DichVuCreateForm;
import com.eaut.quanlybia.form.dichvu.DichVuFilerForm;
import com.eaut.quanlybia.form.dichvu.DichVuUpdateForm;
import com.eaut.quanlybia.service.DichVuService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@AllArgsConstructor
public class DichVuController {
    private DichVuService dichVuService;

    @PostMapping("/api/v1/dichvu/create")
    public DichVuDto create(@RequestBody DichVuCreateForm form) {
        return dichVuService.create(form);
    }

    @GetMapping("/api/v1/dichvu/findAll")
    public Page<DichVuDto> findAll(DichVuFilerForm form, Pageable pageable) {
        return dichVuService.findAll(form, pageable);
    }

    @GetMapping("/api/v1/dichvu/{tenDV}")
    public Page<DichVuDto> findByTenDichVuLike(@PathVariable("tenDV") String tenDV, Pageable pageable) {
        return dichVuService.findByTenDichVuLike("%" + tenDV + "%", pageable);
    }

    @PutMapping("/api/v1/dichvu/{MDV}")
    public DichVuDto update(@RequestBody DichVuUpdateForm form, @PathVariable("MDV") Integer MDV){
        return dichVuService.update(form, MDV);
    }

    @DeleteMapping("/api/v1/dichvu/{MDV}")
    public void deleteByMdv(@PathVariable("MDV") Integer MDV) {
        dichVuService.deleteByMdv(MDV);
    }
}
