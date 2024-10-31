package com.eaut.quanlybia.repository;

import com.eaut.quanlybia.Entity.NhanVien;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface NhanVienRepository extends JpaRepository<NhanVien, Integer>, JpaSpecificationExecutor<NhanVien> {
    NhanVien findByMnv(Integer mnv);
    Page<NhanVien> findByTenNhanVienLike(String tenNhanVien, Pageable pageable);

    Page<NhanVien> findBySdtLike(String std, Pageable pageable);

    NhanVien findBySdt(String sdt);
}
