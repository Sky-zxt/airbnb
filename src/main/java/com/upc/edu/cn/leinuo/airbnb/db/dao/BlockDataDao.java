package com.upc.edu.cn.leinuo.airbnb.db.dao;

import com.upc.edu.cn.leinuo.airbnb.db.dto.BlockDataDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

public interface BlockDataDao extends JpaRepository<BlockDataDto, Integer> {
    List<BlockDataDto> findByDateTimeIsBetween(Timestamp start, Timestamp end);
    BlockDataDto findOneById(Integer id);
}
