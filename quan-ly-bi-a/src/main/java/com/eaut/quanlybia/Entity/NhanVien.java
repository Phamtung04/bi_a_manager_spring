package com.eaut.quanlybia.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "nhan_vien")
public class NhanVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mnv")
    private int mnv;

    @Column(name = "ten_nhan_vien",length = 30, nullable = false)
    private String tenNhanVien;

    @Column(name = "sdt", length = 13, nullable = false)
    private String sdt;

    @Column(name = "nam_sinh")
    private LocalDate namSinh;

    @Column(name = "ca_lam_viec", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private CaLamViec caLamViec;

    @Column(name = "gioi_tinh", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private GioiTinh gioiTinh;

    @Column(name = "mat_khau", length = 255, nullable = false)
    private String matKhau;
    private ChucVu chucVu;

    @OneToMany(mappedBy = "nhanVien", cascade = CascadeType.ALL)
    private List<HoaDon> hoaDons;


    public void setCaLamViec(String caLamViec) {
        this.caLamViec = CaLamViec.valueOf(caLamViec);
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = GioiTinh.valueOf(gioiTinh);
    }

    public enum CaLamViec {
        SANG, CHIEU, TOI
    }

    public enum GioiTinh {
        NAM, NU
    }
    public enum ChucVu{
        ADMIN, EMPLOYEE
    }
}
