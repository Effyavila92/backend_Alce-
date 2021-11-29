package com.misiontic.alcesteMs.models;

import org.springframework.data.annotation.Id;

import java.util.Date;


public class Account {
    @Id
    private String  email;
    private Integer balance;
    private Date    lastChange;

    public Account(String email, Integer balance, Date lastChange){
        this.email      = email;
        this.balance    = balance;
        this.lastChange = lastChange;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public Date getLastChange() {
        return lastChange;
    }

    public void setLastChange(Date lastChange) {
        this.lastChange = lastChange;
    }
}
