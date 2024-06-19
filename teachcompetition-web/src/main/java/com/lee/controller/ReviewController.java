package com.lee.controller;

import com.lee.domains.ResponseResult;
import com.lee.domains.entity.Review;
import com.lee.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    //---------------------------------上传评分------------------------
    @PostMapping("/save")
    public ResponseResult saveReview(@RequestBody Review review) {
        return reviewService.saveReview(review);
    }
    //---------------------------------某位具体专家评分作品------------------------
    @GetMapping("/{workId}/{expertId}")
    public ResponseResult getReviewByWorkIdAndExpertId(@PathVariable Integer workId, @PathVariable Integer expertId) {
        return reviewService.getReviewByWorkIdAndExpertId(workId, expertId);
    }
}
