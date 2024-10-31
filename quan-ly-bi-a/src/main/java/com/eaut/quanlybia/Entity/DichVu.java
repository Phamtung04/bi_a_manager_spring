package com.eaut.quanlybia.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "dichVu")
public class DichVu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MDV")
    private int mdv;

    @Column(name = "tenDichVu", length = 30, nullable = false)
    private String tenDichVu;


    @Column(name = "donGia", nullable = false)
    private float donGia;



}
