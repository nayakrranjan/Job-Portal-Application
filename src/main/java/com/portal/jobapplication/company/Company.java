package com.portal.jobapplication.company;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.portal.jobapplication.job.Job;
import com.portal.jobapplication.review.Review;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Company {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String desc;
    private String location;

    @JsonIgnore
    @OneToMany(mappedBy = "company")
    private List<Job> jobs;

//    @OneToMany
//    private List<Review> reviews;

    public Company() {
    }

    public Company(int id, String name, String desc, String location, List<Job> jobs) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.location = location;
        this.jobs = jobs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }
}
