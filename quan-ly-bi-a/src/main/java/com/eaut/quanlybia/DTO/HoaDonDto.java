package com.eaut.quanlybia.DTO;

import com.eaut.quanlybia.Entity.DichVu;
import com.eaut.quanlybia.Entity.Voucher;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
public class HoaDonDto {
    private int maHoaDon;
    private int mnv;
    private LocalDateTime gioBatDau;
    private LocalDateTime gioKetThuc;
    private String tongThoiGian;
    private List<DichVu> dichVus;
    private float tongtien;
    private int vouchers;
}
