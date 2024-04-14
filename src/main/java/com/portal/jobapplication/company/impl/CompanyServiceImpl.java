package com.portal.jobapplication.company.impl;

import com.portal.jobapplication.company.Company;
import com.portal.jobapplication.company.CompanyRepository;
import com.portal.jobapplication.company.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {
    CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> getAll() {
        return companyRepository.findAll();
    }

    @Override
    public Company createCompany(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public Company updateById(int id, Company company) {
        Company comp = companyRepository.findById(id).orElse(null);
        if (comp != null) {
            comp.setName(company.getName());
            comp.setAbout(company.getAbout());
            comp.setLocation(company.getLocation());
            comp.setJobs(company.getJobs());
            comp.setReviews(company.getReviews());
            companyRepository.save(comp);
        }
        return comp;
    }

    @Override
    public Company getById(int id) {
        return companyRepository.findById(id).orElse(null);
    }

    @Override
    public Company deleteById(int id) {
        Company company = companyRepository.findById(id).orElse(null);
        companyRepository.deleteById(id);
        return company;
    }
}
