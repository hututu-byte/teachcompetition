package com.lee.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lee.domains.ResponseResult;
import com.lee.domains.entity.Review;
import com.lee.domains.vo.ReviewVo;

public interface ReviewService {
    ResponseResult<Page<ReviewVo>> list(String expertName, String title, String school, String teamMembers, String category, Integer pageNum, Integer pageSize);

    ResponseResult saveReview(Review review);
    ResponseResult getReviewByWorkIdAndExpertId(Integer workId, Integer expertId);
}
