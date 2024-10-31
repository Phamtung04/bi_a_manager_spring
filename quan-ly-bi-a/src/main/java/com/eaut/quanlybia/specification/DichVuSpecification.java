package com.eaut.quanlybia.specification;

import com.eaut.quanlybia.Entity.DichVu;
import com.eaut.quanlybia.form.dichvu.DichVuFilerForm;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import java.util.LinkedList;

public class DichVuSpecification {
    public static Specification<DichVu> buildSpec(DichVuFilerForm form) {
        return form == null ? null : (Specification<DichVu>) (root, query, builder) -> {
            var predicates = new LinkedList<Predicate>();

            var search = form.getSearch();
            if(StringUtils.hasText(search)) {
                var pattern = "%" + search.trim() + "%";
                var predication = builder.like(root.get("tenDichVu"), pattern);
                predicates.add(predication);
            }

            return builder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
