package com.eaut.quanlybia.form.dichvu;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class DichVuUpdateForm {
    @NotBlank(message = "Tên dịch vụ không được để trống")
    @Length(message = "Tên dịch vụ tối đa 30 ký tự", max = 30)
    private String tenDichVu;

    @NotBlank(message = "Đơn giá không được để trống")
    private float donGia;
}
