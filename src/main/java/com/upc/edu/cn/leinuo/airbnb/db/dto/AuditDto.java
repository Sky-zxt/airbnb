package com.upc.edu.cn.leinuo.airbnb.db.dto;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Accessors(chain = true)
@Table
@Entity
public class AuditDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer blockDataId;

    private String auditName = "NO_NAME";

    private Integer auditLevel = 1;

    private String result = "NO_AUDIT";

    private String detail = "";

    private String type = "NORMAL";

    @CreationTimestamp
    private Timestamp createTime;

    @UpdateTimestamp
    private Timestamp updateTime;
}
