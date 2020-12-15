package com.mgrapp.GrzegorzDawidek.mgrapp.model.dto;


import java.sql.Date;

public class ReserveArticleDto {
    private Date reservedate;
    private String articleid;

    public String getArticleid() {
        return articleid;
    }

    public void setArticleid(String articleid) {
        this.articleid = articleid;
    }

    public Date getReservedate() {
        return reservedate;
    }

    public void setReservedate(Date reservedate) {
        this.reservedate = reservedate;
    }
}
