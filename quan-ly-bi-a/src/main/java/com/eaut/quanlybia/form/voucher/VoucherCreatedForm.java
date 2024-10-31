package com.eaut.quanlybia.form.voucher;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class VoucherCreatedForm {
    @NotBlank(message = "tên voucher không được để trống")
    @Length(message = "tên voucher tối đa 30 ký tự", max = 30)
    private String tenVoucher;

    @NotBlank(message = "Giá trị không được nhập âm và để trống")
    @Length(message = "Giá trị nhập từ 0 - 100", max = 100)
    private short giaTri;

}
