package com.eaut.quanlybia.repository;

import com.eaut.quanlybia.Entity.HoaDon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HoaDonRepository extends JpaRepository<HoaDon, Integer> {
    HoaDon findByMaHoaDon(Integer mhd);
}
