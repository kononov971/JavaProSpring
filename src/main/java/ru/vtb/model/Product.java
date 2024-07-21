package ru.vtb.model;

import java.math.BigDecimal;

public class Product {

    private Long id;
    private Long accountNum;
    private BigDecimal balance;
    private String type;
    private Long userId;

    public Product() {
    }

    public Product(Long id, Long accountNum, BigDecimal balance, String type, Long userId) {
        this.id = id;
        this.accountNum = accountNum;
        this.balance = balance;
        this.type = type;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(Long accountNum) {
        this.accountNum = accountNum;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
