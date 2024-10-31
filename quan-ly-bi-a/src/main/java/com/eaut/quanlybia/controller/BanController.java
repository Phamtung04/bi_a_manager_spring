package com.eaut.quanlybia.controller;

import com.eaut.quanlybia.DTO.BanDto;
import com.eaut.quanlybia.form.Ban.BanCreateForm;
import com.eaut.quanlybia.form.Ban.BanUpdateForm;
import com.eaut.quanlybia.service.BanService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@AllArgsConstructor
public class BanController {
    private BanService banService;

    @PostMapping("/api/v1/Ban")
    public BanDto create(@RequestBody BanCreateForm form) {
        return banService.create(form);
    }

    @GetMapping("/api/v1/Ban")
    public Page<BanDto> findAll(Pageable pageable) {
        return banService.findAll(pageable);
    }

    @PutMapping("/api/v1/Ban/{mb}")
    public BanDto update(@RequestBody BanUpdateForm form,@PathVariable("mb") Integer mb) {
        return banService.update(form, mb);
    }

    @DeleteMapping("/api/v1/Ban/{mb}")
    public void deleteByMaBan(@PathVariable Integer mb) {
        banService.deleteByMaBan(mb);
    }
}
