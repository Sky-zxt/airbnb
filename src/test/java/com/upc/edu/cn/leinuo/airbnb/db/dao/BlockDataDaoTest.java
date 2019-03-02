package com.upc.edu.cn.leinuo.airbnb.db.dao;

import com.upc.edu.cn.leinuo.airbnb.db.dto.BlockDataDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@Slf4j
@RunWith(SpringRunner.class)
public class BlockDataDaoTest {

    @Autowired
    private BlockDataDao blockDataDao;
    @Test
    public void test() throws Exception {
        BlockDataDto blockDataDto = new BlockDataDto()
                .setRequestToken("123456")
                .setContent("这个房子非常好")
                .setType("text")
                ;
        this.blockDataDao.save(blockDataDto);
        List<BlockDataDto> blockDataDtoList = this.blockDataDao.findAll();
        log.info(blockDataDtoList.toString());
        Assert.assertNotEquals(blockDataDtoList.size(), 0);
    }


}