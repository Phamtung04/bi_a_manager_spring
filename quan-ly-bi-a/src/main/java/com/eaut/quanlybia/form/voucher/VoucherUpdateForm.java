package com.eaut.quanlybia.form.voucher;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class VoucherUpdateForm {
    @NotBlank(message = "tên voucher không được để trống")
    @Length(message = "tên voucher tối đa 30 ký tự", max = 30)
    private String tenVoucher;


    private short giaTri;
}
