package com.eaut.quanlybia.specification;

import com.eaut.quanlybia.Entity.DatBan;
import com.eaut.quanlybia.form.datban.DatBanFilerForm;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import java.util.LinkedList;

public class DatBanSpecification {
//    public static Specification<DatBan> buildSpec(DatBanFilerForm form) {
//        return form == null ? null : (Specification<DatBan>) (root, query, builder) -> {
//            var predicates = new LinkedList<Predicate>();
//
//            var search = form.getSearch();
//            if (StringUtils.hasText(search)) {
//                var parttern = "%" + search.trim() + "%";
//                var predicate = builder.like(root.get(""))
//            }
//        }
//    }
}
