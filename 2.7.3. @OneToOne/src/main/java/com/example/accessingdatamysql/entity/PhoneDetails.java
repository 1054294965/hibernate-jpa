package com.example.accessingdatamysql.entity;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity(name = "PhoneDetails")
public class PhoneDetails {

    @Id
    @GeneratedValue
    private Long id;

    private String provider;

    private String technology;

    @OneToOne(
            fetch = FetchType.LAZY
//            cascade = CascadeType.REMOVE
//            orphanRemoval = true
    )
    @JoinColumn(name = "phone_id")
    private Phone phone;

    //Getters and setters are omitted for brevity
    public PhoneDetails(){

    }
    public PhoneDetails(String provider, String technology) {
        this.provider = provider;
        this.technology = technology;
    }

}
