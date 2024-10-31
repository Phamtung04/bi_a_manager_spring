package com.eaut.quanlybia.service;

import com.eaut.quanlybia.DTO.HoaDonDto;
import com.eaut.quanlybia.form.hoadon.HoaDonCreateForm;

public interface HoaDonService {
    HoaDonDto create(HoaDonCreateForm form);
}
