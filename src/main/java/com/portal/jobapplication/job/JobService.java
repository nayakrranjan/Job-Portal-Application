package com.portal.jobapplication.job;

import java.util.List;

public interface JobService {
    List<Job> findAll();
    void createJob(Job job);
    Job getJobById(int id);
    Job deleteJobById(int Id);

    Job updateById(int id, Job requestBody);
}
