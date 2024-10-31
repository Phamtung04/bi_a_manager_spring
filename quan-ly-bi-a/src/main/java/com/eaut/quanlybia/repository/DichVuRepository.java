package com.eaut.quanlybia.repository;

import com.eaut.quanlybia.Entity.DichVu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface DichVuRepository extends JpaRepository<DichVu, Integer>, JpaSpecificationExecutor<DichVu> {
    DichVu findByMdv(Integer mdv);
    Page<DichVu> findByTenDichVuLike(String tenDV, Pageable pageable);
}
