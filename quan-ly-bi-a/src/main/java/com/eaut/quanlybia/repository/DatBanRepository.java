package com.eaut.quanlybia.repository;

import com.eaut.quanlybia.DTO.DatBanDto;
import com.eaut.quanlybia.Entity.DatBan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface DatBanRepository extends JpaRepository<DatBan, Integer>, JpaSpecificationExecutor<DatBan> {
    DatBan findByMdb(Integer mdb);

}
