package com.eaut.quanlybia.service;

import com.eaut.quanlybia.DTO.HoaDonDto;
import com.eaut.quanlybia.Entity.*;
import com.eaut.quanlybia.Mapper.HoaDonMapper;
import com.eaut.quanlybia.form.hoadon.HoaDonCreateForm;
import com.eaut.quanlybia.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class HoaDonServiceImpl implements HoaDonService {
    private HoaDonRepository hoaDonRepository;
    private DatBanRepository datBanRepository;
    private DichVuRepository dichVuRepository;
    private NhanVienRepository nhanVienRepository;
    private VoucherRepository voucherRepository;

    public HoaDonDto create(HoaDonCreateForm form) {
        var hoaDon = HoaDonMapper.map(form);
        var mdv = form.getMdv();
        float tongTien = 0;
        DatBan datBan = datBanRepository.findByMdb(form.getMdb());
        NhanVien nhanVien = nhanVienRepository.findByMnv(form.getMnv());
        List<DichVu> dichVus = new ArrayList<>();
        for (Integer i : mdv) {
            var dichVu = dichVuRepository.findByMdv(i);
            tongTien += dichVu.getDonGia();
            dichVus.add(dichVu);
        }

        var hangKH = datBan.getKhachHang().getHang();
        var mkh = datBan.getKhachHang().getMkh();
        var voucher = voucherRepository.findByHangAndKhachHang(hangKH,mkh).getGiaTri();

//        var bans = ban.getDonGia();
        var thoiGianDat = datBan.getGioBatDau();
        var tienCoc = datBan.getTienCoc();
        DateTimeFormatter dinhDang = DateTimeFormatter.ofPattern("yyyy-MM-dd:HH:mm");
        var thoiGiaKetThuc = LocalDateTime.parse(form.getThoiGianKetThuc(), dinhDang);
        hoaDon.setGioKetThuc(thoiGiaKetThuc);
        var hours = ChronoUnit.HOURS.between(thoiGianDat,thoiGiaKetThuc);
        var minutes = ChronoUnit.MINUTES.between(thoiGianDat, thoiGiaKetThuc)%60;
        tongTien +=(datBan.getBan().getDonGia()/60)*(minutes);
        tongTien += (hours*(datBan.getBan().getDonGia()));
        var giamGia = (tongTien * voucher) / 100;
        tongTien -= giamGia - tienCoc;
        hoaDon.setTongtien(tongTien);
        hoaDon.setDichVus(dichVus);
        hoaDon.setDatBan(datBan);
        hoaDon.setNhanVien(nhanVien);
        var saveHoaDon = hoaDonRepository.save(hoaDon);
        var dto = HoaDonMapper.map(saveHoaDon);
        dto.setVouchers(voucher);
        dto.setTongThoiGian(hours+":"+minutes );
        return dto;
    }
}
