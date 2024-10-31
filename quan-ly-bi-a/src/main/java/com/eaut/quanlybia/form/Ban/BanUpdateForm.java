package com.eaut.quanlybia.form.Ban;

import com.eaut.quanlybia.Entity.Ban;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BanUpdateForm {
    @Pattern(regexp = "VIP|THUONG", message = "Loại bàn không được để trống")
    private Ban.LoaiBan loaiBan;

    @NotBlank(message = "Đơn giá không được để trống")
    private float donGia;
}
