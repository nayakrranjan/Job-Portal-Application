package com.portal.jobapplication.job;

import com.portal.jobapplication.company.Company;
import com.portal.jobapplication.company.CompanyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JobController {
    private final JobService jobService;
    private final CompanyService companyService;

    public JobController(JobService jobService, CompanyService companyService) {
        this.jobService = jobService;
        this.companyService = companyService;
    }

    @GetMapping("/jobs")
    public List<Job> findAll() {
        return jobService.findAll();
    }

    @PostMapping("/jobs")
    public String createJob(@RequestBody Job job) {
        try {
            Company company = job.getCompany();
            if (company != null) {
                if (companyService.getById(company.getId()) == null) {
                    companyService.createCompany(company);
                }
            }
            jobService.createJob(job);
            return "Added Successfully";
        } catch (Error e) {
            return "Failed";
        }
    }

    @GetMapping("/jobs/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable int id) {
        if (jobService.getJobById(id) != null)
            return ResponseEntity.ok(jobService.getJobById(id));

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/jobs/{id}")
    public ResponseEntity<Job> deleteById(@PathVariable int id) {
        Job job = jobService.deleteJobById(id);
        if (job != null)
            return ResponseEntity.ok(job);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/jobs/{id}")
    public ResponseEntity<Job> updateById(@PathVariable int id, @RequestBody Job requestBody) {
        requestBody.setId(id);
        Job job = jobService.updateById(id, requestBody);
        if (job != null)
            return ResponseEntity.ok(job);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello";
    }
}
