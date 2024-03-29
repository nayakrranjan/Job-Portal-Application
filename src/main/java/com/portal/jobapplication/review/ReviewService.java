package com.portal.jobapplication.review;

import java.util.List;

public interface ReviewService {
    List<Review> getByCompany(int companyId);
    Review creteReview(Review review, int companyId);
    Review getById(int id, int companyId);
    Review updateById(int companyId, int id, Review requestBody);
    Review deleteById(int id);
}
