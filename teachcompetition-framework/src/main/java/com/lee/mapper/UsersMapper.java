package com.lee.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lee.domains.vo.AccountVo;
import com.lee.domains.entity.Users;
import org.apache.ibatis.annotations.Select;


/**
 * (Users)表数据库访问层
 *
 * @author makejava
 * @since 2024-06-15 21:43:27
 */
public interface UsersMapper extends BaseMapper<Users> {


    @Select("SELECT * FROM users WHERE username = #{username}")
    Users findByUsername(String username);


//    @Select("SELECT u.role, w.school, u.name, w.category, u.username " +
//            "FROM users u " +
//            "LEFT JOIN works w ON u.user_id = w.user_id " +
//            "ORDER BY u.user_id")
//    Page<AccountVo> selectAccounts(Page<AccountVo> page);




}

