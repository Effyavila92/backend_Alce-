package com.misiontic.alcesteMs.models;

import org.springframework.data.annotation.Id;

import java.util.Date;

public class Transaction {
    @Id
    private String  id;
    private String  emailOrigin;
    private String  emailDestiny;
    private Integer value;
    private String  note;
    private Date    date;

    public Transaction(String id, String emailOrigin, String emailDestiny, Integer value, String note, Date date){
        this.id             = id;
        this.emailOrigin    = emailOrigin;
        this.emailDestiny   = emailDestiny;
        this.value          = value;
        this.note           = note;
        this.date           = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmailOrigin() {
        return emailOrigin;
    }

    public void setEmailOrigin(String emailOrigin) {
        this.emailOrigin = emailOrigin;
    }

    public String getEmailDestiny() {
        return emailDestiny;
    }

    public void setEmailDestiny(String emailDestiny) {
        this.emailDestiny = emailDestiny;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
