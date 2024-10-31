package com.eaut.quanlybia.specification;

import com.eaut.quanlybia.Entity.Voucher;
import com.eaut.quanlybia.form.voucher.VoucherFilerForm;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import java.util.LinkedList;

public class VoucherSpecification {
    public static Specification<Voucher> bildSpec(VoucherFilerForm form) {
        return form == null ? null :((root, query, builder) -> {
            var predicates = new LinkedList<Predicate>();

            var search = form.getSearch();
            if (StringUtils.hasText(search)) {
                var pattern = "%" + search.trim() + "%";
                var hasTenVoucherLike = builder.like(root.get("tenVoucher"), pattern);
                var predicate = builder.or(hasTenVoucherLike);
                predicates.add(predicate);
            }

            var hang = form.getHang();
            if (hang != null) {
                var predicate = builder.equal(root.get("hang"), hang);
                predicates.add(predicate);
            }

            return builder.and(predicates.toArray(new Predicate[0]));
        });
    }
}
