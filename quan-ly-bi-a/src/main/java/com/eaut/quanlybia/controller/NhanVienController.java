package com.eaut.quanlybia.controller;

import com.eaut.quanlybia.DTO.NhanVienDto;
import com.eaut.quanlybia.form.NhanVien.NhanVienCreateForm;
import com.eaut.quanlybia.form.NhanVien.NhanVienFilerForm;
import com.eaut.quanlybia.form.NhanVien.NhanVienUpdateForm;
import com.eaut.quanlybia.service.NhanVienService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class NhanVienController {
    private NhanVienService nhanVienService;

    @PostMapping("/api/v1/NhanVien")
    public NhanVienDto create(@RequestBody NhanVienCreateForm form) {
        return nhanVienService.create(form);
    }

    @PutMapping("/api/v1/NhanVien/{mnv}")
    public NhanVienDto update(@RequestBody NhanVienUpdateForm form, @PathVariable("mnv") Integer mnv) {
        return nhanVienService.update(form, mnv);
    }

    @DeleteMapping("/api/v1/NhanVien/{mnv}")
    public void deleteByMnv(@PathVariable("mnv") Integer mnv) {
        nhanVienService.deleteByMnv(mnv);
    }

    @GetMapping("/api/v1/NhanVien")
    public Page<NhanVienDto> findAll(NhanVienFilerForm form, Pageable pageable) {
        return nhanVienService.findAll(form, pageable);
    }

    @GetMapping("/api/v1/NhanVien/tennhanvien/{tnv}")
    public Page<NhanVienDto> findByTenNhanVienLike(@PathVariable("tnv") String tnv, Pageable pageable) {
        return nhanVienService.findByTenNhanVienLike("%" + tnv + "%", pageable);
    }

    @GetMapping("/api/v1/NhanVien/sdt/{sdt}")
    public Page<NhanVienDto> findBySdtLike(@PathVariable("sdt") String sdt, Pageable pageable) {
        return nhanVienService.findBySdtLike("%" + sdt + "%", pageable);
    }

}
