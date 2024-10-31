package com.eaut.quanlybia.repository;

import com.eaut.quanlybia.Entity.Ban;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BanRepository extends JpaRepository<Ban, Integer> {
    Ban findByMaBan(Integer maBan);
}
