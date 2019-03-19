package com.upc.edu.cn.leinuo.airbnb.db.dao;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@SpringBootTest
@Slf4j
@RunWith(SpringRunner.class)
public class BlockDataDaoTest {

    @Autowired
    private BlockDataDao blockDataDao;
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");


    @Test
    public void getAllByDateTimeBetween() throws ParseException {

//        Long start = sdf.parse("2019-03-01").getTime();
//        Long end = sdf.parse("2019-03-02").getTime();
//        System.out.println(start);
//        System.out.println(end);
        System.out.println(blockDataDao.findOneById(1));
//        System.out.println(blockDataDao.findByDateTimeIsBetween(new Timestamp(start), new Timestamp(end)));
//        Long a = 1551463000000L;
//        Long b = 1551463002000L;
//        System.out.println(blockDataDao.findByDateTimeIsBetween(new Timestamp(a), new Timestamp(b)));
//        System.out.println(new Timestamp(a) + " " + new Timestamp(b));
    }

}