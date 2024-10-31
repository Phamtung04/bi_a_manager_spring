package com.eaut.quanlybia.form.datban;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DatBanUpdateForm {
    @NotBlank(message = "MB không được để trống")
    private int mb;
}
