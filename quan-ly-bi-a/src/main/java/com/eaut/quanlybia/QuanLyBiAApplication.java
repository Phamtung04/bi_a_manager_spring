package com.eaut.quanlybia;

import com.eaut.quanlybia.Entity.NhanVien;
import com.eaut.quanlybia.repository.NhanVienRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.util.Set;

@AllArgsConstructor
@SpringBootApplication
public class QuanLyBiAApplication implements CommandLineRunner {
	private PasswordEncoder passwordEncoder;
	private NhanVienRepository nhanVienRepository;

	public static void main(String[] args) {
		SpringApplication.run(QuanLyBiAApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var nhanVien = new NhanVien();
		nhanVien.setTenNhanVien("Nguyen Hai Duong");
		nhanVien.setSdt("0987654321");
		var encodedPassword = passwordEncoder.encode("admin");
		nhanVien.setMatKhau(encodedPassword);
		nhanVien.setChucVu(NhanVien.ChucVu.ADMIN);
		nhanVien.setNamSinh(LocalDate.parse("2002-03-04"));
		nhanVien.setGioiTinh("NAM");
		nhanVien.setCaLamViec("TOI");
		nhanVienRepository.save(nhanVien);
	}

}
