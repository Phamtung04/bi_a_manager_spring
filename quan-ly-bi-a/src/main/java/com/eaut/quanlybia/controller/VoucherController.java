package com.eaut.quanlybia.controller;

import com.eaut.quanlybia.DTO.VoucherDto;
import com.eaut.quanlybia.form.voucher.VoucherCreatedForm;
import com.eaut.quanlybia.form.voucher.VoucherFilerForm;
import com.eaut.quanlybia.form.voucher.VoucherUpdateForm;
import com.eaut.quanlybia.service.VoucherService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
public class VoucherController {
    private VoucherService voucherService;

    @PostMapping("/api/v1/eaut/voucher/{hang}")
    public List<VoucherDto> create(@RequestBody VoucherCreatedForm form, @PathVariable("hang") Integer hang) {
        return voucherService.create(form, hang);
    }

    @GetMapping("/api/v1/eaut/voucher/findAll")
    public Page<VoucherDto> findAll(VoucherFilerForm form, Pageable pageable) {
        return voucherService.findAll(form, pageable);
    }

    @GetMapping("/api/v1/eaut/voucher/tenVC/{tenVC}")
    public Page<VoucherDto> findByTenVoucherLike(@PathVariable("tenVC") String tenVC, Pageable pageable) {
        return voucherService.findByTenVoucherLike("%" + tenVC + "%", pageable);
    }

    @GetMapping("/api/v1/eaut/voucher/hang/{hang}")
    public Page<VoucherDto> findByHang(@PathVariable("hang") Integer hang, Pageable pageable) {
        return voucherService.findByHang(hang, pageable);
    }

    @PutMapping("/api/v1/eaut/voucher/update/{hang}")
    public List<VoucherDto> update(@Valid @RequestBody VoucherUpdateForm form, @PathVariable("hang") Integer hang) {
        return voucherService.update(form, hang);
    }

    @DeleteMapping("/api/v1/eaut/voucher/delete/{hang}")
    public void deleteByHang(@PathVariable("hang") Integer hang) {
        voucherService.deleteByHang(hang);
    }
}
