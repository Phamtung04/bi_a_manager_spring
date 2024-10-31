package com.eaut.quanlybia.form.Ban;

import com.eaut.quanlybia.Entity.Ban;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class BanCreateForm {
    @Pattern(regexp = "VIP|THUONG", message = "Loại bàn không được để trống")
    private Ban.LoaiBan loaiBan;

    @NotBlank(message = "Đơn giá không được để trống")
    private float donGia;
}
