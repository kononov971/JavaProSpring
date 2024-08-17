package ru.vtb.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "products")
public class Product {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "account_num")
    private Long accountNum;

    @Column(name = "balance")
    private BigDecimal balance;

    @Column(name = "type")
    private String type;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
