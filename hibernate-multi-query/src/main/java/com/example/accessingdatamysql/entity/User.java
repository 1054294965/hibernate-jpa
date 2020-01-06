package com.example.accessingdatamysql.entity;

import com.fasterxml.jackson.databind.ser.Serializers;
import lombok.Data;
import org.hibernate.annotations.GeneratorType;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@Entity
@Table
public class User extends BaseEntity {

    private String username;
    private String password;
    private String mobile;
    private String address;
    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            orphanRemoval = true
    )
    private List<Order> orders=new ArrayList<>();


    @NaturalId
    private String registrationNumber;

    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<UserAddress> addresses = new ArrayList<>();
    public User(){}

    public User(String registrationNumber){
        this.registrationNumber= registrationNumber;
    }
    public void addAddress(Address address) {
        UserAddress userAddress = new UserAddress( this, address );
        addresses.add(userAddress);
        address.getUsers().add(userAddress);
    }

    public void removeAddress(Address address) {
        UserAddress userAddress = new UserAddress( this, address );
        address.getUsers().remove(userAddress);
        addresses.remove(userAddress);
        userAddress.setUser( null );
        userAddress.setAddress( null );
    }




}
