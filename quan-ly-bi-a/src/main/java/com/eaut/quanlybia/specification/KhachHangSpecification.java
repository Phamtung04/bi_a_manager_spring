package com.eaut.quanlybia.specification;

import com.eaut.quanlybia.Entity.KhachHang;
import com.eaut.quanlybia.form.khachhang.KhachHangFilerForm;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import java.util.LinkedList;

public class KhachHangSpecification {
    public static Specification<KhachHang> buildSpec(KhachHangFilerForm form) {
        return form == null ? null : ((root, query, builder) -> {
            var predicates = new LinkedList<Predicate>();

            var search = form.getSearch();
            if (StringUtils.hasText(search)) {
                var pattern = "%" + search + "%";
                var hasIdLike = builder.like(root.get("MKH"), pattern);
                var hasNameLike = builder.like(root.get("ten_khach_hang"), pattern);
                var predicate = builder.or(hasIdLike, hasNameLike);
                predicates.add(predicate);
            }

            var MKH = form.getMKH();
            if (MKH != null) {
                var predicate = builder.equal(root.get("MKH"), MKH);
                predicates.add(predicate);
            }

            return builder.and(predicates.toArray(new Predicate[0]));
        });
    }
}
