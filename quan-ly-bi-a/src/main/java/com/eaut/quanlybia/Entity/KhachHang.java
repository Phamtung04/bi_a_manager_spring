package com.eaut.quanlybia.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.Table;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "khach_hang")
public class KhachHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MKH")
    private int mkh;

    @Column(name = "ten_khach_hang", length = 30)
    private String tenKhachHang;

    @Column(name = "gioi_tinh", nullable = false)
    @Enumerated(EnumType.STRING)
    private GioiTinh gioiTinh;

    @Column(name = "SDT", length = 13)
    private String sdt;

    @Column(name = "mat_khau", length = 30, nullable = false)
    private String matKhau;

    @Column(name = "hang", length = 30, nullable = false)
    private int hang;

    @OneToMany(mappedBy = "khachHang", cascade = CascadeType.ALL)
    private List<Voucher> vouchers;

    @OneToMany(mappedBy = "khachHang", cascade = CascadeType.ALL)
    private List<DatBan> datBans;

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = GioiTinh.valueOf(gioiTinh);
    }

    public enum GioiTinh {
        NAM, NU
    }


}



