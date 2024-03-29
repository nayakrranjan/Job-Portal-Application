package com.portal.jobapplication.review;

import com.portal.jobapplication.company.CompanyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies/{companyId}")
public class ReviewController {

    private ReviewService reviewService;
    private CompanyService companyService;

    public ReviewController(ReviewService reviewService, CompanyService companyService) {
        this.reviewService = reviewService;
        this.companyService = companyService;
    }

    @GetMapping("/reviews")
    List<Review> getByCompany(@PathVariable int companyId) {
        return reviewService.getByCompany(companyId);
    }

    @PostMapping("/reviews")
    public ResponseEntity<String> createReview(@RequestBody Review review, @PathVariable int companyId) {
        if (reviewService.creteReview(review, companyId) != null) {
            return new ResponseEntity<>("Created", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Company Not Found", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/reviews/{reviewId}")
    public ResponseEntity<Review> getById(@PathVariable int reviewId, @PathVariable int companyId) {
        Review review = reviewService.getById(reviewId, companyId);
        if (review != null)
            return ResponseEntity.ok(review);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/reviews/{reviewId}")
    public ResponseEntity<Review> updateById(@PathVariable int reviewId, @RequestBody Review requestBody, @PathVariable int companyId) {
        Review review = reviewService.updateById(companyId, reviewId, requestBody);
        if (review != null)
            return ResponseEntity.ok(review);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/reviews/{reviewId}")
    public ResponseEntity<Review> deleteById(@PathVariable int reviewId, @PathVariable int companyId) {
        Review review = reviewService.getById(reviewId, companyId);
        if (review != null)
            return ResponseEntity.ok(reviewService.deleteById(reviewId));
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
