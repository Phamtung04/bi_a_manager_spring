package com.eaut.quanlybia.service;

import com.eaut.quanlybia.DTO.VoucherDto;
import com.eaut.quanlybia.Entity.KhachHang;
import com.eaut.quanlybia.Entity.Voucher;
import com.eaut.quanlybia.Mapper.KhachHangMapper;
import com.eaut.quanlybia.Mapper.VoucherMapper;
import com.eaut.quanlybia.form.khachhang.KhachHangFilerForm;
import com.eaut.quanlybia.form.voucher.VoucherCreatedForm;
import com.eaut.quanlybia.form.voucher.VoucherFilerForm;
import com.eaut.quanlybia.form.voucher.VoucherUpdateForm;
import com.eaut.quanlybia.repository.KhachHangRepository;
import com.eaut.quanlybia.repository.VoucherRepository;
import com.eaut.quanlybia.specification.KhachHangSpecification;
import com.eaut.quanlybia.specification.VoucherSpecification;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class VoucherServiceImpl implements VoucherService{
    private VoucherRepository voucherRepository;
    private KhachHangRepository khachHangRepository;
    @Override
        public List<VoucherDto> create(VoucherCreatedForm form, Integer hang) {
            var vouchers = new ArrayList<VoucherDto>();
            var khachHangList = khachHangRepository.findByHang(hang);
            if(!khachHangList.isEmpty()){
                for (KhachHang khachHang : khachHangList) {
                    var voucher = VoucherMapper.map(form);
                    voucher.setHang(khachHang.getHang());
                    voucher.setKhachHang(khachHang);
                    Voucher saveVoucher = voucherRepository.save(voucher);
                    vouchers.add(VoucherMapper.map(saveVoucher));
                }
            }
            return vouchers;
        }

    @Override
    public Page<VoucherDto> findAll(VoucherFilerForm form, Pageable pageable) {
        var spec = VoucherSpecification.bildSpec(form);
        return voucherRepository.findAll(spec, pageable).map(VoucherMapper::map);
    }

    @Override
    public Page<VoucherDto> findByTenVoucherLike(String tenVC, Pageable pageable) {
        return voucherRepository.findByTenVoucherLike(tenVC, pageable).map(VoucherMapper :: map);
    }

    @Override
    public Page<VoucherDto> findByHang(Integer hang, Pageable pageable) {
        return voucherRepository.findByHang(hang, pageable).map(VoucherMapper :: map);
    }

    @Override
    public List<VoucherDto> update(VoucherUpdateForm form, Integer hang) {
        var voucherList = new ArrayList<VoucherDto>();
        var vouchers = voucherRepository.findByHang(hang);
        if (!vouchers.isEmpty()) {
            for (Voucher voucher : vouchers) {
                VoucherMapper.map(form, voucher);
                var savedVoucher = voucherRepository.save(voucher);
                voucherList.add(VoucherMapper.map(savedVoucher));
            }
        }
        return voucherList;
    }

    @Override
    @Transactional
    public void deleteByHang(Integer hang) {
        voucherRepository.deleteByhang(hang);
    }


}
