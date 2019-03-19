package com.upc.edu.cn.leinuo.airbnb.controller;

import com.upc.edu.cn.leinuo.airbnb.config.Result;
import com.upc.edu.cn.leinuo.airbnb.config.enums.DatabaseEnumUtil;
import com.upc.edu.cn.leinuo.airbnb.config.enums.db.BlockDataResultEnum;
import com.upc.edu.cn.leinuo.airbnb.config.exception.SystemException;
import com.upc.edu.cn.leinuo.airbnb.db.dao.BlockDataDao;
import com.upc.edu.cn.leinuo.airbnb.db.dto.BlockDataDto;
import com.upc.edu.cn.leinuo.airbnb.service.HttpRequestService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import static com.upc.edu.cn.leinuo.airbnb.config.enums.DatabaseValueEnum.BLOCK_DATA_DTO_VALUE_ERROR;
import static com.upc.edu.cn.leinuo.airbnb.config.enums.UserStatusEnum.*;

@CrossOrigin(origins = "*", allowCredentials = "true")
@RestController
@RequestMapping("/data")
public class BlockDataController {

    @Autowired
    private HttpRequestService httpRequestService;
    @Autowired
    private DatabaseEnumUtil databaseEnumUtil;
    @Autowired
    private BlockDataDao blockDataDao;

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @PutMapping("/block")
    @ApiOperation(value = "接收数据传入数据库", notes = "接收数据传入数据库")
    public Result save(@ApiParam(required = true, name = "blockDataDto", value = "传入数据")@RequestBody BlockDataDto blockDataDto) {
        System.out.println(blockDataDto);
        BlockDataDto result = blockDataDao.save(blockDataDto);
        System.out.println(result);
        return Result.success(result);
    }

    @GetMapping("/{startTime}/{endTime}/getBlockBetweenDate")
    @ApiOperation(value = "根据时间获取数据", notes = "根据时间获取数据详情")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(required = true, paramType = "path", name = "startTime", value = "2019-03-01"),
            @ApiImplicitParam(required = true, paramType = "path", name = "endTime", value = "2019-03-02")
    })
    public Result findBetweenDate(@PathVariable("startTime") String startTime,
                                  @PathVariable("endTime") String endTime) throws ParseException {
        System.out.println(startTime + " " + endTime);
        long start = sdf.parse(startTime).getTime();
        long end = sdf.parse(endTime).getTime();
        return Result.success(blockDataDao.findByDateTimeIsBetween(new Timestamp(start), new Timestamp(end)));
    }


}
