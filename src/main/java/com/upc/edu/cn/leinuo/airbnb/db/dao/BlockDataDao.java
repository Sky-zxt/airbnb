package com.upc.edu.cn.leinuo.airbnb.db.dao;

import com.upc.edu.cn.leinuo.airbnb.db.dto.BlockDataDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlockDataDao extends JpaRepository<BlockDataDto, Integer> {

}
