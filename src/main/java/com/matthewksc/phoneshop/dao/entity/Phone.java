package com.matthewksc.phoneshop.dao.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "Phones")
public class Phone {

    @Id
    private String Id;
    private String model;

    @Indexed(direction = IndexDirection.ASCENDING)
    private Double price;
    private Company company;
    private List<Reviews> reviews = new ArrayList<>();

    public Phone() {
    }

    public Phone(String model, Double price, Company company, List<Reviews> reviews) {
        this.model = model;
        this.price = price;
        this.company = company;
        this.reviews = reviews;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Reviews> getReviews() {
        return reviews;
    }

    public void setReviews(List<Reviews> reviews) {
        this.reviews = reviews;
    }
}
