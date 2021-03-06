package com.upc.edu.cn.leinuo.airbnb.service;

import com.upc.edu.cn.leinuo.airbnb.db.dao.BlockDataDao;
import com.upc.edu.cn.leinuo.airbnb.db.dto.BlockDataDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@Service
public class HttpRequestService {
    @Value("${audit.callback-url}")
    public String URL;
    @Autowired
    private BlockDataDao blockDataDao;

    public ResponseEntity<String> sendResult(BlockDataDto blockDataDto) throws URISyntaxException {
        RequestEntity<BlockDataDto> requestEntity = RequestEntity
                .post(new URI(URL)).contentType(MediaType.APPLICATION_JSON)
                .body(blockDataDao.findOneById(1));
        ResponseEntity<String> responseEntity = new RestTemplate().exchange(requestEntity, String.class);
        return responseEntity;
    }

}
