package com.eaut.quanlybia.service;

import com.eaut.quanlybia.DTO.NhanVienDto;
import com.eaut.quanlybia.Entity.NhanVien;
import com.eaut.quanlybia.Mapper.NhanVienMapper;
import com.eaut.quanlybia.form.NhanVien.NhanVienCreateForm;
import com.eaut.quanlybia.form.NhanVien.NhanVienFilerForm;
import com.eaut.quanlybia.form.NhanVien.NhanVienUpdateForm;
import com.eaut.quanlybia.repository.NhanVienRepository;
import com.eaut.quanlybia.specification.NhanVienSpecification;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@AllArgsConstructor
public class NhanVienServiceImpl implements NhanVienService, UserDetailsService {
    private NhanVienRepository nhanVienRepository;
    private PasswordEncoder passwordEncoder;

    @Override
    public NhanVienDto update(NhanVienUpdateForm form, Integer mnv) {
        var nhanVien = nhanVienRepository.findById(mnv).get();
        var encodePass = passwordEncoder.encode(form.getMatKhauCu());
        if (encodePass.equals(nhanVien.getMatKhau())) {
            var encodePassNew = passwordEncoder.encode(form.getMatKhauMoi());
            nhanVien.setMatKhau(encodePassNew);
        }
        NhanVienMapper.map(form, nhanVien);
        var saveNhanVien = nhanVienRepository.save(nhanVien);
        return NhanVienMapper.map(saveNhanVien);
    }

    @Override
    public void deleteByMnv(Integer mnv) {
        nhanVienRepository.deleteById(mnv);
    }

    @Override
    public Page<NhanVienDto> findAll(NhanVienFilerForm form, Pageable pageable) {
        var spec = NhanVienSpecification.buildSpec(form);
        return nhanVienRepository.findAll(spec, pageable).map(NhanVienMapper::map);
    }

    @Override
    public NhanVienDto create(NhanVienCreateForm form) {
        var nhanVien = NhanVienMapper.map(form);
        nhanVien.setChucVu(NhanVien.ChucVu.EMPLOYEE);
        var encodePass = passwordEncoder.encode(form.getMatKhau());
        nhanVien.setMatKhau(encodePass);
        var saveNhanVien = nhanVienRepository.save(nhanVien);
        return NhanVienMapper.map(saveNhanVien);
    }

    @Override
    public Page<NhanVienDto> findBySdtLike(String sdt, Pageable pageable) {
        return nhanVienRepository.findBySdtLike(sdt, pageable).map(NhanVienMapper::map);
    }

    @Override
    public Page<NhanVienDto> findByTenNhanVienLike(String tenNhanVien, Pageable pageable) {
        return nhanVienRepository.findByTenNhanVienLike(tenNhanVien, pageable).map(NhanVienMapper::map);
    }

    @Override
    public UserDetails loadUserByUsername(String sdt) throws UsernameNotFoundException {
        var nhanVien = nhanVienRepository.findBySdt(sdt);
        if(nhanVien == null){
            throw new UsernameNotFoundException(sdt);
        }
        var authorities = new ArrayList<GrantedAuthority>();
        var chucVu = nhanVien.getChucVu();
        var auth = new SimpleGrantedAuthority(String.valueOf(chucVu));
        authorities.add(auth);
        return new User(sdt, nhanVien.getMatKhau(), authorities);
    }
}
