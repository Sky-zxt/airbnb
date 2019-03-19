package com.upc.edu.cn.leinuo.airbnb.controller;

import com.upc.edu.cn.leinuo.airbnb.config.Result;
import com.upc.edu.cn.leinuo.airbnb.config.enums.DatabaseEnumUtil;
import com.upc.edu.cn.leinuo.airbnb.config.enums.db.BlockDataResultEnum;
import com.upc.edu.cn.leinuo.airbnb.config.exception.SystemException;
import com.upc.edu.cn.leinuo.airbnb.db.dao.AuditDao;
import com.upc.edu.cn.leinuo.airbnb.db.dao.BlockDataDao;
import com.upc.edu.cn.leinuo.airbnb.db.dto.AuditDto;
import com.upc.edu.cn.leinuo.airbnb.db.dto.BlockDataDto;
import com.upc.edu.cn.leinuo.airbnb.service.HttpRequestService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.net.URISyntaxException;
import java.util.List;

import static com.upc.edu.cn.leinuo.airbnb.config.enums.DatabaseValueEnum.*;
import static com.upc.edu.cn.leinuo.airbnb.config.enums.UserStatusEnum.*;
import static com.upc.edu.cn.leinuo.airbnb.config.enums.db.BlockDataResultEnum.*;


@RestController
@RequestMapping("/audit")
@CrossOrigin(origins = "*", allowCredentials = "true")
public class AuditController {
    @Autowired
    private BlockDataDao blockDataDao;
    @Autowired
    private HttpRequestService httpRequestService;
    @Autowired
    private AuditDao auditDao;

    @Value(value = "${audit.max-audit-level}")
    private final Integer MAX_AUDIT_LEVEL = 2;

    @PatchMapping("/{blockDataId}/{auditLevel}/audit")
    @ApiImplicitParams({
            @ApiImplicitParam(required = true, name = "blockDataId", value = "1", paramType = "path", defaultValue = "1"),
            @ApiImplicitParam(required = true, name = "auditLevel", value = "1", paramType = "path", defaultValue = "1"),
            @ApiImplicitParam(required = true, name = "result", value = "审核结果", paramType = "query", defaultValue = "SUCCESS"),
            @ApiImplicitParam(required = true, name = "type", value = "type", paramType = "query", defaultValue = "NORMAL"),
            @ApiImplicitParam(required = true, name = "detail", value = "detail", paramType = "query", defaultValue = "")
    })
    public Result audit(@PathVariable Integer blockDataId, @PathVariable Integer auditLevel,
                        @RequestParam String result, @RequestParam String type,
                        @RequestParam String detail, HttpSession httpSession) throws SystemException, URISyntaxException {
        BlockDataDto blockDataDto = blockDataDao.findOneById(blockDataId);
        if (blockDataDto == null) {
            throw new SystemException(ID_NOT_FOUND);
        }
        List<AuditDto> auditDtoList = auditDao.findAllByBlockDataId(blockDataId);
        if (auditDtoList.size() >= auditLevel) {
            throw new SystemException(REPEAT_AUDIT, "级别为：" + auditDtoList.size() + "已经审核完毕", String.valueOf(auditDtoList));
        }
        if (auditDtoList.size() + 1 != auditLevel) {
            throw new SystemException(LOSS_AUDIT, "级别为：" + auditDtoList.size() + "已经审核完毕", String.valueOf(auditLevel));
        }
        if (auditDtoList.size() > 0 && auditDtoList.get(auditDtoList.size()-1).getResult().equals(FAILED.toString())) {
            throw new SystemException(AUDIT_IS_FAILED, String.valueOf(auditDtoList));
        }
        BlockDataResultEnum auditResult =  DatabaseEnumUtil.findEnumByStr(BlockDataResultEnum.class, result);
        if (auditResult == null) {
            throw new SystemException(BLOCK_DATA_DTO_VALUE_ERROR, "Your input is " + result);
        }
        HttpStatus httpStatus = null;
        if (auditLevel.equals(MAX_AUDIT_LEVEL) && auditResult == SUCCESS) {
            blockDataDto.setResult(SUCCESS.toString());
            /**
             * 审核成功，将数据传入回调接口，
             * 并将回调接口的status code 传入VO对象的附加字段中
             */
            httpStatus = httpRequestService.sendResult(blockDataDto).getStatusCode();
            if (httpStatus != HttpStatus.OK) {
                throw new SystemException(SEND_RESULT_ERROR, httpRequestService.URL, httpStatus.toString());
            }
        } else if (!auditLevel.equals(MAX_AUDIT_LEVEL) && auditResult == SUCCESS) {
            blockDataDto.setResult(PENDING.toString());
        } else {
            blockDataDto.setResult(FAILED.toString()).setType(type).setDetails(detail);
            httpStatus = httpRequestService.sendResult(blockDataDto).getStatusCode();
            if (httpStatus != HttpStatus.OK) {
                throw new SystemException(SEND_RESULT_ERROR, httpRequestService.URL, httpStatus.toString());
            }
        }

        AuditDto auditDto = new AuditDto()
                .setAuditLevel(auditLevel)
                .setBlockDataId(blockDataId)
                .setResult(auditResult.toString());
        auditDao.save(auditDto);
        return Result.success(blockDataDao.save(blockDataDto), "回调返回status " + httpStatus);
    }

    @GetMapping("/{auditLevel}")
    @ApiImplicitParams({
            @ApiImplicitParam(required = true, name = "auditLevel", value = "审核级别", defaultValue = "1")
    })
    public Result listAuditByAuditLevel(@PathVariable Integer auditLevel) throws SystemException {
        if (auditLevel > MAX_AUDIT_LEVEL) {
            throw new SystemException(TOO_MAX_AUDIT_LEVEL, "MAX AUDIT LEVEL IS" + MAX_AUDIT_LEVEL);
        }
        
        return Result.success(auditDao.findAllByAuditLevelOrderByBlockDataId(auditLevel));
    }
}
