package com.matthewksc.phoneshop.dao.entity;

import java.util.Date;

public class Reviews{


    private String user;
    private int rating;
    private Date dateOfRating;

    public Reviews(String user, int rating, Date dateOfRating) {
        this.user = user;
        this.rating = rating;
        this.dateOfRating = dateOfRating;
    }

    public Reviews() {
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Date getDateOfRating() {
        return dateOfRating;
    }

    public void setDateOfRating(Date dateOfRating) {
        this.dateOfRating = dateOfRating;
    }
}
