package com.eaut.quanlybia.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "hoa_don")
public class HoaDon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_hoa_don")
    private int maHoaDon;


    @Column(name = "gio_ket_thuc", nullable = false, updatable = true)
    private LocalDateTime gioKetThuc;


    @Column(name = "tong_tien", nullable = false)
    private float tongtien;

    @ManyToOne
    @JoinColumn(name = "id_nhanVien", referencedColumnName = "mnv")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private NhanVien nhanVien;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "suDungDichVu",
            joinColumns =@JoinColumn(name = "ma_hoa_don"),
            inverseJoinColumns = @JoinColumn(name = "MDV")
    )
    private List<DichVu> dichVus;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_datBan", referencedColumnName = "mdb")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private DatBan datBan;

}
