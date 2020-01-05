package com.example.accessingdatamysql.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity(name = "Person")
public class Person {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    @OneToMany(
            mappedBy = "person",
            cascade= CascadeType.ALL,
            fetch= FetchType.LAZY,
            orphanRemoval = true
    )
    private List<Phone> phoneList;

    public Person(){}
    public Person(String name){
        this.name=name;
    }
    public  void addPhone(Phone phone){
        phone.setPerson(this);
        phoneList.add(phone);
    }
    public  void removePhone(Phone phone){
        phone.setPerson(this);
        phoneList.remove(phone);
    }


}
