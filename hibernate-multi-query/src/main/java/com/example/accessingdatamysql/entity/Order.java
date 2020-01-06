package com.example.accessingdatamysql.entity;

import com.fasterxml.jackson.databind.ser.Serializers;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name="t_order")
public class Order extends BaseEntity {

    private String productName;
    private BigDecimal price;
    private Integer number;
    private BigDecimal amount;
    private String url;
    private String productType;

    @ManyToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @JoinColumn(name="user_id")
    private User user;

    @OneToMany(
            mappedBy = "order",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            orphanRemoval = true
    )
    private List<OrderProduct> orderProducts=new ArrayList<>();

}

