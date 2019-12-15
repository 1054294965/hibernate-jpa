package com.example.accessingdatamysql.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity(name = "Address")
public class Address implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String street;

    @Column(name = "`number`")
    private String number;

    private String postalCode;

    @OneToMany(
            mappedBy = "address",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<PersonAddress> owners = new ArrayList<>();

    //Getters and setters are omitted for brevity

    public Address(String street, String number, String postalCode) {
        this.street = street;
        this.number = number;
        this.postalCode = postalCode;
    }

    @Override
    public boolean equals(Object o) {
        if ( this == o ) {
            return true;
        }
        if ( o == null || getClass() != o.getClass() ) {
            return false;
        }
        Address address = (Address) o;
        return Objects.equals( street, address.street ) &&
                Objects.equals( number, address.number ) &&
                Objects.equals( postalCode, address.postalCode );
    }

    @Override
    public int hashCode() {
        return Objects.hash( street, number, postalCode );
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public List<PersonAddress> getOwners() {
        return owners;
    }

    public void setOwners(List<PersonAddress> owners) {
        this.owners = owners;
    }
}