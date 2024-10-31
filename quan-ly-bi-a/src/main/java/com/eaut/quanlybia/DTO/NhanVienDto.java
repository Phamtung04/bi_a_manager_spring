package com.eaut.quanlybia.DTO;

import com.eaut.quanlybia.Entity.NhanVien;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class NhanVienDto {
    private int mnv;
    private String tenNhanVien;
    private String sdt;
    private LocalDate namSinh;
    private NhanVien.CaLamViec caLamViec;
    private NhanVien.GioiTinh gioiTinh;
}
