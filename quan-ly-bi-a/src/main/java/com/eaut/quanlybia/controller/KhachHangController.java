package com.eaut.quanlybia.controller;


import com.eaut.quanlybia.DTO.khachHangDto;
import com.eaut.quanlybia.form.khachhang.KhachHangCreateForm;
import com.eaut.quanlybia.form.khachhang.KhachHangFilerForm;
import com.eaut.quanlybia.form.khachhang.KhachHangUpdateForm;
import com.eaut.quanlybia.service.KhachHangService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class KhachHangController {
    private KhachHangService khachHangservice;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/api/v1/khachhang")
    public khachHangDto create(@RequestBody KhachHangCreateForm form) {
        return khachHangservice.create(form);
    }


    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @GetMapping("/api/v1/khachhangs")
    public Page<khachHangDto> findAll(KhachHangFilerForm form, Pageable pageable) {
        return  khachHangservice.findAll(form, pageable);
    }

    @GetMapping("/api/v1/khachhang/{MKH}")
    public khachHangDto findByMkh(@PathVariable("MKH") Integer Mkh) {
        return khachHangservice.findByMkh(Mkh);
    }

    @PutMapping("/api/v1/khachhang/update/{MKH}")
    public khachHangDto update(@Valid @RequestBody KhachHangUpdateForm form, @PathVariable("MKH") Integer MKH) {
        return khachHangservice.update(form, MKH);
    }

    @DeleteMapping("/api/v1/khachhang/delete/{MKH}")
    public void deleteByMKH(@PathVariable("MKH") Integer MKH) {
        khachHangservice.deleteByMkh(MKH);
    }

}
