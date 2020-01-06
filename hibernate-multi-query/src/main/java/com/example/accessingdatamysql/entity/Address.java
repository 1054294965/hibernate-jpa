package com.example.accessingdatamysql.entity;

import com.fasterxml.jackson.databind.ser.Serializers;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@Entity
public class Address extends BaseEntity implements Serializable {


    private String street;

    @Column(name = "`number`")
    private String number;

    private String postalCode;

    @OneToMany(
            mappedBy = "address",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<UserAddress> users = new ArrayList<>();

    public Address(){}
    public Address(String street,String number,String postalCode){
        this.street=street;
        this.number=number;
        this.postalCode=postalCode;
    }


}