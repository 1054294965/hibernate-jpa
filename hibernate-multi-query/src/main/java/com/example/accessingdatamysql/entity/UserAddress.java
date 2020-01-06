package com.example.accessingdatamysql.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
@Data
@Entity(name = "UserAddress")
public class UserAddress implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Id
    @ManyToOne
    private User user;

    @Id
    @ManyToOne
    private Address address;
    public UserAddress(){

    }
    public UserAddress(User user, Address address){
        this.user=user;
        this.address=address;
    }


}