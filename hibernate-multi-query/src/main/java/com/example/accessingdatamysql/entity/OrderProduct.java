package com.example.accessingdatamysql.entity;

import lombok.Data;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@Table
public class OrderProduct extends BaseEntity{

    private String productName;
    private BigDecimal price;
    private Integer number;
    private BigDecimal amount;
    private String url;
    private String productType;

    @ManyToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    @JoinColumn(name="order_id")
    private Order order;


}
