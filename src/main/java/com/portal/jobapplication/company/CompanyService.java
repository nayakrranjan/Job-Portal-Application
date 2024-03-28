package com.portal.jobapplication.company;

import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface CompanyService {
    public List<Company> getAll();
    public Company createCompany(Company company);
    public Company updateById(int id, Company company);
    public Company getById(int id);
    public Company deleteById(int id);
}
