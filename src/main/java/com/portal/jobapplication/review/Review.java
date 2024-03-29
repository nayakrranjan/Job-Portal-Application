package com.portal.jobapplication.review;

import com.portal.jobapplication.company.Company;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Review {
    @Id
    @GeneratedValue
    private int Id;
    private String title;
    private String desc;

    @ManyToOne
    private Company company;

    public Review() {}

    public Review(int id, String title, String desc, Company company) {
        Id = id;
        this.title = title;
        this.desc = desc;
        this.company = company;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
