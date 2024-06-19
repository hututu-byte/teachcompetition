package com.lee.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lee.domains.entity.Review;
import com.lee.domains.entity.Users;
import com.lee.domains.vo.ReviewVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ReviewMapper extends BaseMapper<Review> {


    Page<ReviewVo> selectReviews(@Param("page") Page<ReviewVo> page,
                                 @Param("expertName") String expertName,
                                 @Param("title") String title,
                                 @Param("school") String school,
                                 @Param("teamMembers") String teamMembers,
                                 @Param("category") String category);

    @Select("SELECT w.school, w.title, u.name AS expertName, " +
            "r.teaching_report_score AS teachingReportScore, r.lesson_plan_score AS lessonPlanScore, " +
            "r.video_material_score AS videoMaterialScore, r.talent_training_score AS talentTrainingScore, " +
            "r.course_standard_score AS courseStandardScore, r.textbook_usage_score AS textbookUsageScore, " +
            "r.overall_score AS overallScore, r.created_at AS createdAt " +
            "FROM reviews r " +
            "JOIN works w ON r.work_id = w.work_id " +
            "JOIN users u ON r.expert_id = u.user_id " +
            "ORDER BY r.created_at DESC")
    List<ReviewVo> selectAllReviews();
}
