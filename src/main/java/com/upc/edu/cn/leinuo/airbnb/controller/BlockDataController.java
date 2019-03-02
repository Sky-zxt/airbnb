package com.upc.edu.cn.leinuo.airbnb.controller;

import com.upc.edu.cn.leinuo.airbnb.config.Result;
import com.upc.edu.cn.leinuo.airbnb.db.dao.BlockDataDao;
import com.upc.edu.cn.leinuo.airbnb.db.dto.BlockDataDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowCredentials = "true")
@RestController
@RequestMapping("/data")
public class BlockDataController {

    @Autowired
    private BlockDataDao blockDataDao;
    @PutMapping("/")
    public Result save(@RequestBody BlockDataDto blockDataDto) {
        System.out.println(blockDataDto);
        BlockDataDto result = blockDataDao.save(blockDataDto);
        System.out.println(result);
        return Result.success(result);
    }
}
