package com.upc.edu.cn.leinuo.airbnb.db.dao;

import com.upc.edu.cn.leinuo.airbnb.db.dto.AuditDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface AuditDao extends JpaRepository<AuditDto, Integer> {
    AuditDto findOneById(Integer id);

    List<AuditDto> findAllByBlockDataId(Integer id);

    List<AuditDto> findAllByAuditLevelOrderByBlockDataId(Integer auditLevel);
}
