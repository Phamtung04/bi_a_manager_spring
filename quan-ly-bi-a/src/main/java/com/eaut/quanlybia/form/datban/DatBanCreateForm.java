package com.eaut.quanlybia.form.datban;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DatBanCreateForm {
    @NotBlank(message = "MKH không được để trống")
    private int mkh;

    @NotBlank(message = "Tiền cọc không được để trống")
    private float tienCoc;
    private int mb;


}
