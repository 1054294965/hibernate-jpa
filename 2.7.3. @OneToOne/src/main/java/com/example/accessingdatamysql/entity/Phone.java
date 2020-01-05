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

    @OneToOne(
            mappedBy = "phone",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private PhoneDetails details;
    public Phone(){

    }
    public Phone(String number) {
        this.number = number;
    }
    //Getters and setters are omitted for brevity

    public void addDetails(PhoneDetails details) {
        details.setPhone( this );
        this.details = details;
    }

    public void removeDetails() {
        if ( details != null ) {
            details.setPhone( null );
            this.details = null;
        }
    }


}

