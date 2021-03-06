package com.upc.edu.cn.leinuo.airbnb.db.dto;

import com.upc.edu.cn.leinuo.airbnb.config.enums.db.BlockDataResultEnum;
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
public class BlockDataDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String requestToken = "";

    private String content = "";

    private String type = "";

    private String result = BlockDataResultEnum.NO_AUDIT.toString();

    private String label = "NORMAL";

    private String details = "";

    private String agentName = "xinyushushi";

    @CreationTimestamp
    private Timestamp dateTime;

    @UpdateTimestamp
    private Timestamp updateTime;
}
