package com.eaut.quanlybia.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Setter
@Entity
@Table(name = "voucher")
public class Voucher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MVC")
    private int MVC;

    @Column(name = "tenVoucher", length = 30, nullable = false)
    private String tenVoucher;

    @Column(name = "giaTri", length = 10, nullable = false)
    @PositiveOrZero
    @Max(100)
    private short giaTri;

    @Column(name = "hang", nullable = false)
    private int hang;

    @ManyToOne
    @JoinColumn(name = "KhachHang_id", referencedColumnName = "MKH")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private KhachHang khachHang;


}
