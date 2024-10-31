package com.eaut.quanlybia.specification;

import com.eaut.quanlybia.Entity.NhanVien;
import com.eaut.quanlybia.form.NhanVien.NhanVienFilerForm;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import java.util.LinkedList;

public class NhanVienSpecification {
    public static Specification<NhanVien> buildSpec(NhanVienFilerForm form) {
        return form == null ? null : ((root, query, builder) ->{
           var predicates = new LinkedList<Predicate>();

           var search = form.getSearch();
           if (StringUtils.hasText(search)) {
               var pattern = "%" + search.trim() + "%";
               var hasTenNhanVienLike = builder.like(root.get("ten_nhan_vien"), pattern);
               var hasSDTLike = builder.like(root.get("sdt"), pattern);
               var hasCaLamViecLike = builder.like(root.get("ca_lam_viec"), pattern);
               var predicate = builder.or(hasTenNhanVienLike, hasSDTLike, hasCaLamViecLike);
               predicates.add(predicate);
           }

           return builder.and(predicates.toArray(new Predicate[0]));
        });
    }
}
