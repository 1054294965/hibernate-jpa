package com.example.accessingdatamysql.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.print.DocFlavor;

@Entity
public class Person {
    @Id
    private Long id;


    private String name;
    @Column(name="del_flag",columnDefinition = "varchar(255) comment '删除标志 0:未删除 1:已删除' ")
    private String delFlag;
}
