package com.example.accessingdatamysql.entity;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity(name = "Phone")
public class Phone {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "`number`")
    private String number;

    @ManyToOne(

    )
    @JoinColumn(name = "person_id"

    )
    private Person person;

    public Phone(){}
    public Phone(String number){
        this.number=number;
    }


}