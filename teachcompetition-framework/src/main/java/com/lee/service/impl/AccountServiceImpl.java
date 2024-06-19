package com.lee.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lee.domains.ResponseResult;
import com.lee.domains.dto.AccountAddDto;
import com.lee.domains.dto.AccountUpdateDto;
import com.lee.domains.entity.Users;
import com.lee.domains.entity.Work;
import com.lee.domains.vo.AccountVo;
import com.lee.enums.AppHttpCodeEnum;
import com.lee.mapper.AccountMapper;
import com.lee.mapper.UsersMapper;
import com.lee.mapper.WorksMapper;
import com.lee.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private UsersMapper usersMapper;
    @Autowired
    private WorksMapper worksMapper;
    @Autowired
    private AccountMapper accountMapper;
    @Override
    public ResponseResult<Page<AccountVo>> pageQuery(String role, String school, String category, Integer pageNum, Integer pageSize) {
        Page<AccountVo> page = new Page<>(pageNum, pageSize);
        page.setOptimizeCountSql(false);
        Page<AccountVo> accountVoPage = accountMapper.selectAccounts(page, role, school, category);
        return ResponseResult.okResult(accountVoPage);
    }

    @Override
    public ResponseResult add(AccountAddDto accountAddDto) {
        if (accountAddDto.getName() == null || accountAddDto.getName().isEmpty()) {
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID, "请输入姓名");
        }
        if (accountAddDto.getSchool() == null || accountAddDto.getSchool().isEmpty()) {
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID, "请输入学校");
        }
        if (accountAddDto.getRole() == null || accountAddDto.getRole().isEmpty()) {
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID, "请选择身份");
        }
        if (accountAddDto.getRole().equals("expert") && (accountAddDto.getCategory() == null || accountAddDto.getCategory().isEmpty())) {
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID, "请选择评选范围");
        }
        if (accountAddDto.getUsername() == null || accountAddDto.getUsername().isEmpty()) {
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID, "请输入账号");
        }
        if (accountAddDto.getPassword() == null || accountAddDto.getPassword().isEmpty()) {
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID, "请输入密码");
        }

        Users user = new Users();
        user.setName(accountAddDto.getName());
        user.setRole(accountAddDto.getRole());
        user.setUsername(accountAddDto.getUsername());
        user.setPassword(accountAddDto.getPassword());
        // 设置默认头像
        user.setAvatar("https://img.zcool.cn/community/01a3865ab91314a8012062e3c38ff6.png@1280w_1l_2o_100sh.png");

        int result1 = usersMapper.insert(user);
        if (result1 > 0) {
            // 插入成功后，获取生成的 user_id
            Integer userId = user.getUserId();

            // 向 works 表中插入相关信息
            Work work = new Work();
            work.setSchool(accountAddDto.getSchool());
            work.setUserId(userId);
            worksMapper.insert(work);
            return ResponseResult.okResult();
        } else {
            return ResponseResult.errorResult(AppHttpCodeEnum.SYSTEM_ERROR, "出现错误");
        }
    }

    @Override
    public ResponseResult update(Integer userId, AccountUpdateDto accountUpdateDto) {
        if (userId == null) {
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID, "用户ID不能为空");
        }

        Users user = usersMapper.selectById(userId);
        if (user == null) {
            return ResponseResult.errorResult(AppHttpCodeEnum.DATA_NOT_EXIST, "用户不存在");
        }

        user.setName(accountUpdateDto.getName());
        user.setRole(accountUpdateDto.getRole());
        user.setUsername(accountUpdateDto.getUsername());
        user.setPassword(accountUpdateDto.getPassword());

        int result = usersMapper.updateById(user);
        if (result > 0) {
            Work work = worksMapper.selectById(user.getUserId());
            if (work == null) {
                work = new Work();
                work.setUserId(user.getUserId());
                work.setSchool(accountUpdateDto.getSchool());
                worksMapper.insert(work);
            } else {
                work.setSchool(accountUpdateDto.getSchool());
                worksMapper.updateById(work);
            }
            return ResponseResult.okResult();
        } else {
            return ResponseResult.errorResult(AppHttpCodeEnum.SYSTEM_ERROR, "更新用户失败");
        }
    }


    @Override
    public ResponseResult delete(Integer userId) {
        if (userId == null) {
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID, "用户ID不能为空");
        }
        // 删除关联的作品信息
        worksMapper.deleteByUserId(userId);
        int result = usersMapper.deleteById(userId);
        if (result > 0) {
            return ResponseResult.okResult("删除成功");
        } else {
            return ResponseResult.errorResult(AppHttpCodeEnum.SYSTEM_ERROR, "删除用户失败");
        }
    }
}
