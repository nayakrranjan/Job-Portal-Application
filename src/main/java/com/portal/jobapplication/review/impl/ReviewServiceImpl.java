package com.portal.jobapplication.review.impl;

import com.portal.jobapplication.company.Company;
import com.portal.jobapplication.company.CompanyService;
import com.portal.jobapplication.review.Review;
import com.portal.jobapplication.review.ReviewRepository;
import com.portal.jobapplication.review.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    ReviewRepository reviewRepository;
    CompanyService companyService;

    public ReviewServiceImpl(ReviewRepository reviewRepository, CompanyService companyService) {
        this.reviewRepository = reviewRepository;
        this.companyService = companyService;
    }

    @Override
    public List<Review> getByCompany(int companyId) {
        return reviewRepository.findByCompanyId(companyId);
    }

    @Override
    public Review creteReview(Review review, int companyId) {
        Company company = companyService.getById(companyId);
        if (company != null)
            review.setCompany(company);
        else
            return null;
        return reviewRepository.save(review);
    }

    @Override
    public Review getById(int id, int companyId) {
        List<Review> reviews = getByCompany(companyId);
        return reviews.stream().filter(review -> review.getId() == id).findFirst().orElse(null);
    }

    @Override
    public Review updateById(int companyId, int id, Review requestBody) {
        Review review = getById(id, companyId);
        if (review != null) {
            review.setTitle(requestBody.getTitle());
            review.setDescription(requestBody.getDescription());
            review.setCompany(requestBody.getCompany());
            reviewRepository.save(review);
        }
        return review;
    }

    @Override
    public Review deleteById(int id) {
        Review review = reviewRepository.findById(id).orElse(null);
        if (review != null)
            reviewRepository.deleteById(id);
        return review;
    }
}
