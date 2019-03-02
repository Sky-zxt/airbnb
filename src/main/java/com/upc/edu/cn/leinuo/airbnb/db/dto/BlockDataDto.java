package com.upc.edu.cn.leinuo.airbnb.db.dto;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Tables;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

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
    private String agentName = "";
    @CreationTimestamp
    private Date dateTime;
    @UpdateTimestamp
    private Date updateTime;
}
