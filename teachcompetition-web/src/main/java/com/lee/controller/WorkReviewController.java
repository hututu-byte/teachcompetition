package com.lee.controller;

import com.lee.domains.ResponseResult;
import com.lee.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users/works")
public class WorkReviewController {

    @Autowired
    private WorkService workService;
    //---------------------------------专家评审首页------------------------
    @GetMapping("/reviews")
    public ResponseResult getWorkReviews() {
        return ResponseResult.okResult(workService.getWorkReviews());
    }
}
