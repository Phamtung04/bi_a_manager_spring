package com.eaut.quanlybia.controller;

import com.eaut.quanlybia.DTO.HoaDonDto;
import com.eaut.quanlybia.form.hoadon.HoaDonCreateForm;
import com.eaut.quanlybia.service.HoaDonService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class HoaDonController {
    private HoaDonService hoaDonService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/api/v1/HoaDon")
    public HoaDonDto create(@RequestBody HoaDonCreateForm form) {
        return hoaDonService.create(form);
    }
}
