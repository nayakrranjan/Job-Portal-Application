package com.portal.jobapplication.job.Impl;

import com.portal.jobapplication.job.Job;
import com.portal.jobapplication.job.JobRepository;
import com.portal.jobapplication.job.JobService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobServiceImpl implements JobService {
    JobRepository jobRepository;

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public void createJob(Job job) {
        jobRepository.save(job);
    }

    @Override
    public Job getJobById(int id) {
        return jobRepository.findById(id).orElse(null);
    }

    @Override
    public Job deleteJobById(int id) {
        Job job = jobRepository.findById(id).orElse(null);
        if (job != null)
            jobRepository.delete(job);
        return job;
    }

    @Override
    public Job updateById(int id, Job requestBody) {
        Job job = jobRepository.findById(id).orElse(null);
        if (job != null) {
            job.setTitle(requestBody.getTitle());
            job.setDescription(requestBody.getDescription());
            job.setMinSal(requestBody.getMinSal());
            job.setMaxSal(requestBody.getMaxSal());
            job.setLocation(requestBody.getLocation());
            jobRepository.save(job);
        }
        return job;
    }
}
