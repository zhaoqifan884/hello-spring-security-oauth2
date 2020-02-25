package com.zqf.spring.security.oauth2.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zqf.spring.security.oauth2.server.entity.TbUser;
import com.zqf.spring.security.oauth2.server.mapper.TbUserMapper;
import com.zqf.spring.security.oauth2.server.service.TbUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * Author: Bill Chiu(Qifan Zhao)
 * Date: Created in :  2019/11/5 13:46
 * Description:
 *
 * @ Modified By：
 */
@Service
public class TbUserServiceImpl implements TbUserService{

    @Resource
    private TbUserMapper tbUserMapper;
    @Override
    public TbUser getByUserName(String username) {
        return tbUserMapper.selectOne(new QueryWrapper<TbUser>()
                .lambda().eq(TbUser::getUsername,"admin"));
    }
}
