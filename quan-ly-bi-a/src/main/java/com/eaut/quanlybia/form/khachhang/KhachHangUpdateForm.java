package com.eaut.quanlybia.form.khachhang;

import com.eaut.quanlybia.Entity.KhachHang;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class KhachHangUpdateForm {
    @NotBlank(message = "Tên không được để trống")
    @Length(message = "Tên tối đa 30 ký tự", max = 30)
    private  String tenKhachHang;

    @Pattern(regexp = "NAM|NU", message = "Giới tính phải là NAM hoặc NU")
    private String gioiTinh;

    @NotBlank(message = "Tên không được để trống")
    @Length(message = "Tên tối đa 13 số", max = 13)
    private String SDT;

    @Length(message = "Tên tối đa 20 ký tự", max = 20)
    private String matKhau;

    private  int hang;
}
