package com.lee.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lee.domains.entity.Work;
import com.lee.domains.vo.WorkVO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface WorksMapper extends BaseMapper<Work> {

    @Select("SELECT * FROM works WHERE user_id = #{userId}")
    Work selectByUserId(@Param("userId") Integer userId);


    @Delete("DELETE FROM works WHERE user_id = #{userId}")
    void deleteByUserId(@Param("userId") Integer userId);


    Page<WorkVO> selectWorks(@Param("page") Page<WorkVO> page, @Param("title") String title, @Param("school") String school, @Param("teamMembers") String teamMembers);



    @Select("SELECT w.school, w.category, w.title, w.team_members AS teamMembers, w.contact_info AS contactInfo, " +
            "COALESCE(AVG(r.overall_score), 0) AS averageScore, w.created_at AS createdAt " +
            "FROM works w LEFT JOIN reviews r ON w.work_id = r.work_id " +
            "GROUP BY w.school, w.category, w.title, w.team_members, w.contact_info, w.created_at " +
            "ORDER BY w.created_at DESC")
    List<WorkVO> selectAllWorks();



}
