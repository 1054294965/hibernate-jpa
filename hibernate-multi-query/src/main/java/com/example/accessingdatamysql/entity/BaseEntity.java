package com.example.accessingdatamysql.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @CreatedDate
    private Date createDate;

    @LastModifiedDate
    private Date updateDate;

    @CreatedBy
    private String createBy;

    @LastModifiedBy
    private String updateBy;

    @Column(columnDefinition = "varchar(1) default '0' comment '删除标识 0 未删除 1 已删除'")
    private String delFlag;
}
