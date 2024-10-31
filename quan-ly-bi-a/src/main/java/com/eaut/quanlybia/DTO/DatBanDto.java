package com.eaut.quanlybia.DTO;

import com.eaut.quanlybia.Entity.Ban;
import com.eaut.quanlybia.Entity.DichVu;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
public class DatBanDto {
    private int mkh;
    private float tienCoc;
    private LocalDateTime gioBatDau;
    private Ban.LoaiBan loaiBan;
    private Ban.TinhTrang tinhTrang;
    private float donGia;
}
