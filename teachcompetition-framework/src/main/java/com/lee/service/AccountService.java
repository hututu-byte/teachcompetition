package com.lee.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lee.domains.ResponseResult;
import com.lee.domains.dto.AccountAddDto;
import com.lee.domains.dto.AccountUpdateDto;
import com.lee.domains.vo.AccountVo;

public interface AccountService {

    ResponseResult<Page<AccountVo>> pageQuery(String role, String school, String category, Integer pageNum, Integer pageSize);

    ResponseResult add(AccountAddDto accountAddDto);

    ResponseResult update(Integer userId ,AccountUpdateDto accountUpdateDto);

    ResponseResult delete(Integer userId);
}
