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
    private String about;
    private String location;

    @JsonIgnore
    @OneToMany(mappedBy = "company")
    private List<Job> jobs;

    @JsonIgnore
    @OneToMany(mappedBy = "company")
    private List<Review> reviews;

    public Company() {}


    public Company(int id, String name, String about, String location, List<Job> jobs, List<Review> reviews) {
        this.id = id;
        this.name = name;
        this.about = about;
        this.location = location;
        this.jobs = jobs;
        this.reviews = reviews;
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

    public String getAbout() {
        return about;
    }

    public void setAbout(String desc) {
        this.about = desc;
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
    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
}
