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
@Table(name = "dat_ban")
public class DatBan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mdb")
    private int mdb;

    @Column(name = "tienCoc", nullable = false)
    private float tienCoc;

    @Column(name = "gioBatDau", updatable = false, nullable = false)
    @CreationTimestamp
    private LocalDateTime gioBatDau;


    @ManyToOne
    @JoinColumn(name = "id_ban", referencedColumnName = "ma_ban")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Ban ban;

    @ManyToOne
    @JoinColumn(name = "id_Khach_hang", referencedColumnName = "MKH")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private KhachHang khachHang;

    @OneToOne(mappedBy = "datBan")
    private HoaDon hoaDon;


}
