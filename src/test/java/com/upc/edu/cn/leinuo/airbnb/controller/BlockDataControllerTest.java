package com.upc.edu.cn.leinuo.airbnb.controller;

import org.junit.Test;
import org.mockito.internal.verification.Times;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static org.junit.Assert.*;

public class BlockDataControllerTest {

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
    @Test
    public void findBetweenDate() throws ParseException {
        System.out.println(sdf.parse("2019-03-04 01:56:40").getTime());
        System.out.println(sdf.parse("2019-03-05 01:56:42").getTime());
        System.out.println(new Date(1551369600000L));
        System.out.println(new Date(1551456000000L));
        System.out.println(new Timestamp(1551373200000L));


    }
}