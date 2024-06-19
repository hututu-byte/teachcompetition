package com.lee.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lee.domains.vo.AccountVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AccountMapper extends BaseMapper<AccountVo> {

    @Select("SELECT u.role, w.school, u.name, w.category, u.username " +
            "FROM users u " +
            "LEFT JOIN works w ON u.user_id = w.user_id " +
            "ORDER BY u.user_id")
    List<AccountVo> selectAllAccounts();

    Page<AccountVo> selectAccounts(@Param("page") Page<AccountVo> page, @Param("role") String role, @Param("school") String school, @Param("category") String category);
}
