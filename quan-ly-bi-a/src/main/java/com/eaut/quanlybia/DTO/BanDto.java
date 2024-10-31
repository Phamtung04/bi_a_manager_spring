package com.eaut.quanlybia.DTO;

import com.eaut.quanlybia.Entity.Ban;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BanDto {
    private int maBan;
    private Ban.LoaiBan loaiBan;
    private Ban.TinhTrang tinhTrang;
    private float donGia;

}
