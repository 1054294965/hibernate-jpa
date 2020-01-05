package com.example.accessingdatamysql.entity;

import com.fasterxml.jackson.databind.deser.impl.MergingSettableBeanProperty;
import lombok.Data;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@Entity(name = "Person")
public class Person implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @NaturalId
    private String registrationNumber;

    @OneToMany(
            mappedBy = "person",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<PersonAddress> addresses = new ArrayList<>();
    public Person(){}

    public Person(String registrationNumber){
        this.registrationNumber= registrationNumber;
    }
    public void addAddress(Address address) {
        PersonAddress personAddress = new PersonAddress( this, address );
        addresses.add( personAddress );
        address.getOwners().add( personAddress );
    }

    public void removeAddress(Address address) {
        PersonAddress personAddress = new PersonAddress( this, address );
        address.getOwners().remove( personAddress );
        addresses.remove( personAddress );
        personAddress.setPerson( null );
        personAddress.setAddress( null );
    }

    @Override
    public boolean equals(Object o) {
        if ( this == o ) {
            return true;
        }
        if ( o == null || getClass() != o.getClass() ) {
            return false;
        }
        Person person = (Person) o;
        return Objects.equals( registrationNumber, person.registrationNumber );
    }

    @Override
    public int hashCode() {
        return Objects.hash( registrationNumber );
    }
}
