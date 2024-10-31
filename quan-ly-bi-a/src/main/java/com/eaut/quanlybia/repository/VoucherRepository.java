package com.eaut.quanlybia.repository;

import com.eaut.quanlybia.DTO.VoucherDto;
import com.eaut.quanlybia.Entity.Voucher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.nio.file.Path;
import java.util.List;

public interface VoucherRepository extends JpaRepository<Voucher, Integer>, JpaSpecificationExecutor<Voucher> {
    Page<Voucher> findByTenVoucherLike(String tenVoucher, Pageable pageable);

    Page<Voucher> findByHang(Integer hang, Pageable pageable);
    List<Voucher> findByHang(Integer hang);

    @Query(value = "SELECT * FROM voucher WHERE hang = ?1 AND khach_hang_id = ?2", nativeQuery = true)
    Voucher findByHangAndKhachHang(Integer hang, Integer mkh);

    void deleteByhang(Integer hang);
}
