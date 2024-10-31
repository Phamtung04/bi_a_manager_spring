package com.eaut.quanlybia.service;

import com.eaut.quanlybia.DTO.BanDto;
import com.eaut.quanlybia.DTO.DatBanDto;
import com.eaut.quanlybia.Entity.Ban;
import com.eaut.quanlybia.Entity.DichVu;
import com.eaut.quanlybia.Entity.KhachHang;
import com.eaut.quanlybia.Mapper.DatBanMapper;
import com.eaut.quanlybia.form.datban.DatBanCreateForm;
import com.eaut.quanlybia.form.datban.DatBanUpdateForm;
import com.eaut.quanlybia.repository.BanRepository;
import com.eaut.quanlybia.repository.DatBanRepository;
import com.eaut.quanlybia.repository.DichVuRepository;
import com.eaut.quanlybia.repository.KhachHangRepository;
import io.swagger.v3.oas.models.info.License;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class DatBanServiceIpml implements DatBanService {
    private DatBanRepository datBanRepository;
    private BanRepository banRepository;
    private KhachHangRepository khachHangRepository;

    @Override
    public Page<DatBanDto> findAll(Pageable pageable) {
        return datBanRepository.findAll(pageable).map(DatBanMapper :: map);
    }

    @Override
    public DatBanDto update(DatBanUpdateForm form, Integer mdb) {
        var datBan = datBanRepository.findByMdb(mdb);
        var ban = banRepository.findByMaBan(form.getMb());
        datBan.setBan(ban);
        var saveDatBan = datBanRepository.save(datBan);
        return DatBanMapper.map(saveDatBan);
    }

    @Override
    public void deleteByMdb(Integer mdb) {
        datBanRepository.deleteById(mdb);
    }


    @Override
    public DatBanDto create(DatBanCreateForm form ) {
        var datBan = DatBanMapper.map(form);
        KhachHang khachHang = khachHangRepository.findByMkh(form.getMkh());
        Ban ban = banRepository.findByMaBan(form.getMb());
        ban.setTinhTrang(String.valueOf(Ban.TinhTrang.MO));
        datBan.setBan(ban);
        datBan.setKhachHang(khachHang);
        var saveDatBan = datBanRepository.save(datBan);
        return DatBanMapper.map(saveDatBan);
    }
}




// update

//    List<DichVu> dichVus = new ArrayList<>();
//    var MDV = form.getMdv();
//        for (Integer mdv : MDV) {
//                var DichVu = dichVuRepository.findByMdv(mdv);
//                dichVus.add(DichVu);
//                }
//                datBan.setDichVus(dichVus);