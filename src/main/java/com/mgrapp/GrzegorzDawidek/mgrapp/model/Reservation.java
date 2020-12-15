package com.mgrapp.GrzegorzDawidek.mgrapp.model;

import org.springframework.stereotype.Indexed;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
@Indexed
@Table(name = "Reservation")
public class Reservation {
    //timestamp
    private long id;
    private Date date;
    private Time starthour;
    private Time endhour;
    private long itemid;//many to one
    private long userid;


    public long getItemid() {
        return itemid;
    }

    public void setItemid(long itemid) {
        this.itemid = itemid;
    }

    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }

    public Reservation(Date date, long itemid, long userid) {
        this.date = date;
        this.itemid = itemid;
        this.userid = userid;
    }

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Basic
    @Column
    public Time getStarthour() {
        return starthour;
    }

    public void setStarthour(Time starthour) {
        this.starthour = starthour;
    }

    @Basic
    @Column
    public Time getEndhour() {
        return endhour;
    }

    public void setEndhour(Time endhour) {
        this.endhour = endhour;
    }
}
