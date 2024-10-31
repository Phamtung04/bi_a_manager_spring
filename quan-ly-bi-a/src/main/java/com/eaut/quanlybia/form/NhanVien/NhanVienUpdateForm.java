package com.eaut.quanlybia.form.NhanVien;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

@Getter
@Setter
public class NhanVienUpdateForm {

    @NotBlank(message = "Tên nhân viên không được để trống")
    @Length(message = "Tên không được quá 30 ký tự", max = 30)
    private String tenNhanVien;

    @NotBlank(message = "sdt không được để trống")
    @Length(message = "sdt không được quá 13 ký tự", max = 13)
    private String sdt;

    @NotBlank(message = "Năm sinh không được để trống")
    private LocalDate namSinh;

    @Pattern(regexp = "SANG|CHIEU|TOI", message = "Ca làm việc phải là SANG, CHIEU hoặc TOI")
    private String caLamViec;

    @Pattern(regexp = "NAM|NU", message = "Giới tính phải là NAM hoặc NU")
    private String gioiTinh;

    @NotBlank(message = "Mật khẩu không được để trống")
    @Length(message = "Mật khẩu không được quá 20 ký tự", max = 20)
    private String matKhauMoi;

    @NotBlank(message = "Mật khẩu không được để trống")
    @Length(message = "Mật khẩu không được quá 20 ký tự", max = 20)
    private String matKhauCu;

}
