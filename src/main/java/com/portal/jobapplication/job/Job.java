package com.portal.jobapplication.job;

import com.portal.jobapplication.company.Company;
import jakarta.persistence.*;

@Entity
public class Job {

    @Id
    @GeneratedValue
    private int id;
    private String title;
    private String desc;
    private double minSal;
    private double maxSal;
    private String location;

    @ManyToOne
    private Company company;

    public Job() {}

    public Job(int id, String title, String desc, double minSal, double maxSal, String location) {
        this.id = id;
        this.title = title;
        this.desc = desc;
        this.minSal = minSal;
        this.maxSal = maxSal;
        this.location = location;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public double getMinSal() {
        return minSal;
    }

    public void setMinSal(double minSal) {
        this.minSal = minSal;
    }

    public double getMaxSal() {
        return maxSal;
    }

    public void setMaxSal(double maxSal) {
        this.maxSal = maxSal;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
