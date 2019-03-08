package com.upc.edu.cn.leinuo.airbnb.config.enums;

import com.upc.edu.cn.leinuo.airbnb.config.enums.db.BlockDataResultEnum;
import com.upc.edu.cn.leinuo.airbnb.db.dao.BlockDataDao;
import com.upc.edu.cn.leinuo.airbnb.db.dto.BlockDataDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

import static com.upc.edu.cn.leinuo.airbnb.config.enums.DatabaseEnumUtil.*;
import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DatabaseEnumUtilTest {
    private static final String URL = "https://callbacks.airbnb.com/v1/external/callback/hanclean/manual/review";
    public static final String HEADER = "Content-Type: application/json; charset=utf-8";

    @Autowired
    private BlockDataDao blockDataDao;

    @Test
    public void testFindEnumByStr() throws URISyntaxException {
        BlockDataResultEnum pass = findEnumByStr(BlockDataResultEnum.class, "PASS");
        assertEquals(pass.toString(), "PASS");

        System.out.println(blockDataDao.findOneById(1));
        RequestEntity<BlockDataDto> requestEntity = RequestEntity
                .post(new URI(URL)).contentType(MediaType.APPLICATION_JSON)
                .body(blockDataDao.findOneById(1));
        ResponseEntity<String> responseEntity = new RestTemplate().exchange(requestEntity, String.class);
        System.out.println(responseEntity.getBody());
        assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
    }
}