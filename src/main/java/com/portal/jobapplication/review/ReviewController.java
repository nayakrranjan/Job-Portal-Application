package com.portal.jobapplication.review;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReviewController {

    @GetMapping("/companies/{companyId}/reviews")
    public List<Review> getByCompany(@PathVariable String companyId) {
        return null;
    }

    @PostMapping("/companies/{companyId}/reviews")
    public Review createReview(@PathVariable String companyId) {
        return null;
    }

    @GetMapping("/companies/{companyId}/reviews/{reviewId}")
    public List<Review> getById(@PathVariable String companyId, @PathVariable String reviewId) {
        return null;
    }

    @PutMapping("/companies/{companyId}/reviews/{reviewId}")
    public Review updateById(@PathVariable String reviewId, @PathVariable String companyId) {
        return null;
    }

    @DeleteMapping("/companies/{companyId}/reviews/{reviewId}")
    public Review deleteById(@PathVariable String reviewId, @PathVariable String companyId) {
        return null;
    }
}
