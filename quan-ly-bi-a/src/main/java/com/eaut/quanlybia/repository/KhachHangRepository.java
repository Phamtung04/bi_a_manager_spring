package com.eaut.quanlybia.repository;

import com.eaut.quanlybia.Entity.KhachHang;
import com.eaut.quanlybia.Entity.Voucher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface KhachHangRepository extends JpaRepository<KhachHang, Integer>, JpaSpecificationExecutor<KhachHang> {

    List<KhachHang> findByHang(Integer KhachHang);
    KhachHang findByMkh(Integer KhachHang);
}
