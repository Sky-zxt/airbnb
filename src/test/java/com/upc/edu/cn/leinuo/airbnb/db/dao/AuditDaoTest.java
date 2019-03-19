package com.upc.edu.cn.leinuo.airbnb.db.dao;

import com.upc.edu.cn.leinuo.airbnb.db.dto.AuditDto;
import com.upc.edu.cn.leinuo.airbnb.db.dto.BlockDataDto;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class AuditDaoTest {

    @Autowired
    private AuditDao auditDao;
    @Value("${audit.callback-url}")
    private String URL;
    @Test
    public void findAllByAuditLevelOrderByBlockDataId() {
        List<AuditDto> auditDtoList = auditDao.findAllByBlockDataId(1);
    }

    @Test
    public void findAllByBlockDataId() {

    }

    @Test
    public void findOneById() throws URISyntaxException {
//        BlockDataDto blockDataDto = new BlockDataDto().setRequestToken("123312").setContent("测试v7").setType("text")
//                .setResult("FAILED").setDetails("").setLabel("涉黄");
//        RequestEntity<BlockDataDto> requestEntity = RequestEntity
//                .post(new URI(URL))
//                .contentType(MediaType.APPLICATION_JSON)
//                .body(blockDataDto);
//        ResponseEntity<String> result = new RestTemplate().exchange(requestEntity, String.class);
//        System.out.println(result.getStatusCode().value());



    }

}