package com.eaut.quanlybia.controller;

import com.eaut.quanlybia.DTO.DatBanDto;
import com.eaut.quanlybia.form.datban.DatBanCreateForm;
import com.eaut.quanlybia.form.datban.DatBanUpdateForm;
import com.eaut.quanlybia.service.DatBanService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@AllArgsConstructor
public class DatBanController {
    private DatBanService datBanService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/api/v1/datban/create")
    public DatBanDto create(@RequestBody DatBanCreateForm form) {
        return datBanService.create(form);
    }

    @GetMapping("/api/v1/datban")
    public Page<DatBanDto> findAll(Pageable pageable) {
        return datBanService.findAll(pageable);
    }

    @PutMapping("/api/v1/datban/{mdb}")
    public DatBanDto update(@RequestBody DatBanUpdateForm form,@PathVariable("mdb") Integer mdb) {
        return datBanService.update(form, mdb);
    }

    @DeleteMapping("/api/v1/datban/{mdb}")
    public void deleteByMdb(@PathVariable("mdb") Integer mdb) {
        datBanService.deleteByMdb(mdb);
    }


}
