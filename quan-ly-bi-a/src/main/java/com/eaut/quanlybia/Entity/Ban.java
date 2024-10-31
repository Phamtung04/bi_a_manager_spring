package com.eaut.quanlybia.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "Ban")
public class Ban {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_ban")
    private int maBan;

    @Column(name = "loaiBan", nullable = false)
    @Enumerated(EnumType.STRING)
    private LoaiBan loaiBan;

    @Column(name = "tinhTrang", nullable = false)
    @Enumerated(EnumType.STRING)
    private TinhTrang tinhTrang;

    @Column(name = "donGia", nullable = false)
    private float donGia;

    @OneToMany(mappedBy = "ban", cascade = CascadeType.ALL)
    private List<DatBan> datBans;


    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = TinhTrang.valueOf(tinhTrang);
    }

    public enum TinhTrang{
        MO, DONG
    }
    public enum LoaiBan{
        VIP, THUONG
    }
}
