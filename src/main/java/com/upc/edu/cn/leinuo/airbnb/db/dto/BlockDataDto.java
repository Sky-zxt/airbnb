package com.upc.edu.cn.leinuo.airbnb.db.dto;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;
import java.sql.Timestamp;

@Data
@Accessors(chain = true)
@Table
@Entity
public class BlockDataDto {
    @Id
    @GeneratedValue
    private Integer id;
    private String requestToken = "";
    private String content = "";
    private String type = "";
    private String result = "block";
    private String label = "normal";
    private String details = "";
    private String agentName = "xinyushushi";
    @CreationTimestamp
    private Timestamp dateTime;
    @UpdateTimestamp
    private Timestamp updateTime;
}
