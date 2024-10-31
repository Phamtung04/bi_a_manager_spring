package com.eaut.quanlybia.form.hoadon;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
public class HoaDonCreateForm {
    @NotBlank(message = "MSV không được bỏ trống")
    private int mnv;
    private int mdb;
    private String thoiGianKetThuc;
    private List<Integer> mdv;

}
