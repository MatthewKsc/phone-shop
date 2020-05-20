package com.matthewksc.phoneshop.dao.entity;

public class Company {

    private String name;
    private String country;
    private String headquarters;

    public Company(String name, String country, String headquarters) {
        this.name = name;
        this.country = country;
        this.headquarters = headquarters;
    }

    public Company() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getHeadquarters() {
        return headquarters;
    }

    public void setHeadquarters(String headquarters) {
        this.headquarters = headquarters;
    }
}
