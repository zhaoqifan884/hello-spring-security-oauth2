package com.zqf.spring.security.oauth2.server.service;

import com.zqf.spring.security.oauth2.server.entity.TbUser;

/**
 * Created with IntelliJ IDEA.
 * Author: Bill Chiu(Qifan Zhao)
 * Date: Created in :  2019/11/5 13:42
 * Description:
 *
 * @ Modified By：
 */
public interface TbUserService {
    //防止sql注入   先拿到用户名   在拿密码
    TbUser getByUserName(String username);
}
