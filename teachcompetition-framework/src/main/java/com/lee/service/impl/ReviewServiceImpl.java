package com.lee.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lee.domains.ResponseResult;
import com.lee.domains.entity.Review;
import com.lee.domains.entity.Work;
import com.lee.domains.vo.ReviewVo;
import com.lee.enums.AppHttpCodeEnum;
import com.lee.mapper.ReviewMapper;
import com.lee.mapper.WorksMapper;
import com.lee.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service("reviewService")
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewMapper reviewMapper;
    @Autowired
    private WorksMapper workMapper;

    @Override
    public ResponseResult<Page<ReviewVo>> list(String expertName, String title, String school, String teamMembers, String category, Integer pageNum, Integer pageSize) {
        Page<ReviewVo> page = new Page<>(pageNum, pageSize);
        page.setOptimizeCountSql(false);
        Page<ReviewVo> reviewPage = reviewMapper.selectReviews(page, expertName, title, school, teamMembers, category);
        return ResponseResult.okResult(reviewPage);
    }

    @Override
    public ResponseResult saveReview(Review review) {
        // 检查 workId 是否存在
        if (review.getWorkId() == null) {
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID,"作品ID不能为空");
        }

        // 计算总分
        double overallScore = review.getTeachingReportScore() + review.getLessonPlanScore() +
                review.getVideoMaterialScore() + review.getTalentTrainingScore() +
                review.getCourseStandardScore() + review.getTextbookUsageScore();
        review.setOverallScore(overallScore);

        if (review.getReviewId() == null) {
            // 设置创建时间
            review.setCreatedAt(LocalDateTime.now());
            reviewMapper.insert(review);
        } else {
            Review existingReview = reviewMapper.selectById(review.getReviewId());
            if (existingReview != null) {
                review.setCreatedAt(existingReview.getCreatedAt());
            }
            reviewMapper.updateById(review);
        }

        // 更新 works 表中的 qualification 字段
        Work work = workMapper.selectById(review.getWorkId());
        if (work != null && work.getQualification() == 0) {
            work.setQualification((byte) 1);
            workMapper.updateById(work);
        }
        return ResponseResult.okResult(review);
    }

    @Override
    public ResponseResult getReviewByWorkIdAndExpertId(Integer workId, Integer expertId) {
        QueryWrapper<Review> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("work_id", workId).eq("expert_id", expertId)
                .orderByDesc("created_at").last("LIMIT 1");
        Review review = reviewMapper.selectOne(queryWrapper);
        if (review == null) {
            return ResponseResult.errorResult(AppHttpCodeEnum.NOT_POINT,"评分记录不存在");
        }
        return ResponseResult.okResult(review);
    }
}
