package com.eaut.quanlybia.DTO;

import com.eaut.quanlybia.Entity.KhachHang;
import com.eaut.quanlybia.controller.KhachHangController;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Getter
@Setter
public class khachHangDto extends RepresentationModel<khachHangDto> {
    private  int mkh;
    private  String tenKhachHang;
    private KhachHang.GioiTinh gioiTinh;
    private String Sdt;
    private  int hang;

    public khachHangDto withSelfRel() {
        var controller = methodOn(KhachHangController.class);
        var dto = controller.findByMkh(mkh);
        var link = linkTo(dto).withSelfRel();
        return add(link);
    }

}
