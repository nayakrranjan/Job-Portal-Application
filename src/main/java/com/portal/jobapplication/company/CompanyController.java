package com.portal.jobapplication.company;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CompanyController {
    CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/companies")
    public List<Company> getAll() {
        return companyService.getAll();
    }

    @PostMapping("/companies")
    public ResponseEntity<Company> createCompany(@RequestBody Company company) {
        return new ResponseEntity<>(companyService.createCompany(company), HttpStatus.CREATED);
    }

    @PutMapping("/companies/{id}")
    public ResponseEntity<Company> updateById(@PathVariable int id, @RequestBody Company company) {
        Company  comp = companyService.updateById(id, company);
        if (comp!= null)
            return ResponseEntity.ok(comp);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/companies/{id}")
    public ResponseEntity<Company> getById(@PathVariable int id) {
        Company company = companyService.getById(id);
        if (company != null)
            return ResponseEntity.ok(company);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/companies/{id}")
    public ResponseEntity<Company> deleteById(@PathVariable int id) {
        Company company = companyService.deleteById(id);
        if (company != null)
            return ResponseEntity.ok(company);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
